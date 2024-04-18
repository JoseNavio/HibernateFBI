import connection.ConnectionHibernate;
import connection.ConnectionMySQL;
import data.hibernate.Delito;
import data.hibernate.Estado;
import data.hibernate.Sospechoso;
import data.xml.Crime;
import data.xml.FederalData;
import data.xml.Suspect;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Constants;
import util.Utils;
import util.XMLManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.util.*;

/**
 * Main
 *
 * @author Jose L. Navío Mendoza
 */

public class Main {

    private static Connection connectionMySQL;
    public static Session session = null;
    public static Transaction transaction = null;

    public static void main(String[] args) {

        //Generate a connection to the database
        connectionMySQL = ConnectionMySQL.connect();

        resetDatabase();

        //Get the route to the valid XML files
        List<String> validXMLs = validateXMLs();
        //Load the suspects from the XML files
        if (!validXMLs.isEmpty()) {

            Set<Suspect> uniqueSuspects = new HashSet();

            for (String xmlRoute : validXMLs) {

                //Read the XML file
                FederalData federalData = XMLManager.readFBIXML(xmlRoute);

                //Add the suspects to the set to avoid duplicates (Fichas son idénticas...)
                if (!federalData.getSuspects().isEmpty()) {
                    for (Suspect newSuspect : federalData.getSuspects()) {
                        boolean found = false;
                        //Cause a suspect can have multiple crimes...
                        for (Suspect existingSuspect : uniqueSuspects) {
                            if (existingSuspect.getRecord().equals(newSuspect.getRecord())) {
                                existingSuspect.getCrimes().addAll(newSuspect.getCrimes());
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            uniqueSuspects.add(newSuspect);
                        }
                    }
                }
            }

            //Add the photos to the suspects
            for (Suspect suspect : uniqueSuspects) {
                suspect.setPhoto(Utils.imageToBase64(suspect.getPhoto()));
            }

            //todo Just for testing purposes
            for (Suspect suspect : uniqueSuspects) {
                System.out.println(suspect);
                System.out.println("--------------------------------------------------");
            }

            insertSuspects(uniqueSuspects);

            insertNewCrime();

            showSuspectGivenItsRecord("LLF455");
        }
    }

    //1.
    //Runs the FBI.sql script to reset the database
    private static void resetDatabase() {

        ScriptRunner scriptRunner;
        scriptRunner = new ScriptRunner(connectionMySQL);
        try {
            scriptRunner.runScript(new FileReader(Constants.FBI_SQL));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<String> validateXMLs() {

        List<String> validXMLs = new ArrayList<>();

        if (XMLManager.validateXMLwithXSD(Constants.SOSPECHOSOS_01_SQL, Constants.SOSPECHOSOS_XSD))
            validXMLs.add(Constants.SOSPECHOSOS_01_SQL);

        if (XMLManager.validateXMLwithXSD(Constants.SOSPECHOSOS_02_SQL, Constants.SOSPECHOSOS_XSD))
            validXMLs.add(Constants.SOSPECHOSOS_02_SQL);

        return validXMLs;
    }

    private static void insertSuspects(Set<Suspect> suspects) {

        session = ConnectionHibernate.getSessionFactory().openSession();
        transaction = session.beginTransaction();

        for (Suspect suspect : suspects) {
            Sospechoso sospechoso = new Sospechoso();
            Estado estado = new Estado();
            sospechoso.setFicha(suspect.getRecord());
            estado.setEstado(suspect.getState());
            estado.setNombreEstado(suspect.getStateName());
            sospechoso.setEstado(estado);
            sospechoso.setNombre(suspect.getName());
            sospechoso.setSexo(suspect.getSex());
            sospechoso.setAltura(String.valueOf(suspect.getHeight()));
            sospechoso.setPeso(String.valueOf(suspect.getWeight()));
            sospechoso.setFechaNacimiento(suspect.getBirthdate());
            sospechoso.setFoto(suspect.getPhoto());
            List<Delito> delitos = new ArrayList<>();
            for (Crime crime : suspect.getCrimes()) {
                Delito delito = new Delito();
                delito.setToken(Utils.generateToken(suspect.getRecord() + crime.getDate()));
                delito.setFicha(sospechoso);
                delito.setFecha(crime.getDate());
                delito.setTipo(crime.getType());
                delito.setObservaciones(crime.getObservation());
                delitos.add(delito);
            }
            sospechoso.setDelitos(delitos);

            for (Delito delito : delitos) {
                session.persist(delito);
            }

            session.persist(sospechoso);
            session.persist(estado);
        }

        transaction.commit();
    }
    //2.
    //Insert a new crime
    private static void insertNewCrime() {
        transaction = session.beginTransaction();

        Sospechoso sospechoso = (Sospechoso) session.createQuery("FROM Sospechoso WHERE ficha = :ficha").setParameter("ficha", "LLF455").uniqueResult();

        sospechoso.setEstado(new Estado("CA", "California"));

        Delito delito = new Delito();
        delito.setFicha(sospechoso);
        delito.setTipo("Robo de vehículos");
        delito.setFecha("2024-05-01T13:45:00");
        delito.setObservaciones("Realizó el robo de vehículos de alta game en la ciudad de Los Angeles.");
        delito.setToken(Utils.generateToken(delito.getTipo() + delito.getFecha()));
        session.persist(sospechoso.getEstado());
        session.persist(delito);
        session.merge(sospechoso);
        session.getTransaction().commit();
    }
    //3.
    //Show the suspect given its record
    private static void showSuspectGivenItsRecord(String record) {

        Sospechoso sospechoso = (Sospechoso) session.createQuery("FROM Sospechoso WHERE ficha = :ficha").setParameter("ficha", record).uniqueResult();

        if (sospechoso != null) {
            List<Delito> delitos = session.createQuery("FROM Delito WHERE ficha = :ficha").setParameter("ficha", sospechoso).list();
            sospechoso.setDelitos(delitos);
            System.out.println(sospechoso);
        } else {
            // If the Sospechoso does not exist, get all Sospechoso objects
            List<Sospechoso> sospechosos = session.createQuery("FROM Sospechoso").list();
            for (Sospechoso s : sospechosos) {
                List<Delito> delitos = session.createQuery("FROM Delito WHERE ficha = :ficha").setParameter("ficha", s).list();
                s.setDelitos(delitos);
                System.out.println(s);
            }
        }
    }
}