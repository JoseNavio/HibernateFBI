import connection.ConnectionMySQL;
import data.xml.FederalData;
import data.xml.Suspect;
import org.apache.ibatis.jdbc.ScriptRunner;
import util.Constants;
import util.XMLManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.*;

/**
 * Main
 *
 * @author Jose L. Navío Mendoza
 */

public class Main {

    private static Connection connectionMySQL;

    public static void main(String[] args) {

        //Generate a connection to the database
        connectionMySQL = ConnectionMySQL.connect();

//        resetDatabase();

        //Get the route to the valid XML files
        List<String> validXMLs = validateXMLs();
        //Load the suspects from the XML files
        if (!validXMLs.isEmpty()) {

            Set<Suspect> uniqueSuspects = new HashSet();

            for (String xmlRoute : validXMLs) {

                //Read the XML file
                FederalData federalData = XMLManager.readFBIXML(xmlRoute);
                //Add the suspects to the set to avoid duplicates (Fichas son idénticas...)
                if (!federalData.getSuspects().isEmpty()){
                    uniqueSuspects.addAll(federalData.getSuspects());
                }
            }

            //Add the photos to the suspects
            for(Suspect suspect : uniqueSuspects){
                suspect.setPhoto(imageToBase64(suspect.getPhoto()));
            }

            //todo Just for testing purposes
            for (Suspect suspect : uniqueSuspects) {
                System.out.println(suspect);
                System.out.println("--------------------------------------------------");
            }
        }
    }

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

    private static String imageToBase64(String imageName) {

        String imagePath = "src/main/resources/" + imageName + ".png";

        try {
            byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch ( IOException e) {
            throw new RuntimeException(e);
        }
    }
}