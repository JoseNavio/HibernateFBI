package data.xml;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Objects;

/**
 * Suspect
 *
 * @author Jose L. Navío Mendoza
 */
@XmlRootElement(name = "Sospechoso")
@XmlAccessorType(XmlAccessType.FIELD)
public class Suspect {

    @XmlAttribute(name = "ficha")
    String record;
    @XmlAttribute(name = "estado")
    String state;
    @XmlAttribute(name = "nombreEstado")
    String stateName;
    @XmlElement(name = "Nombre")
    String name;
    @XmlElement(name = "Sexo")
    String sex;
    @XmlElement(name = "Altura")
    int height;
    @XmlElement(name = "Peso")
    int weight;
    @XmlElement(name = "FechaNacimiento")
    String birthdate;

    @XmlElement(name = "Foto")
    String photo;

    @XmlElement(name = "Delito")
    List<Crime> crimes;

    public Suspect() {
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getState() {
        return state;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setState(String stateName) {
        this.stateName = stateName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        switch (sex) {
            case "Varón":
                return "V";
            case "Hembra":
                return "H";
            default:
                return "I";
        }
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Crime> getCrimes() {
        return crimes;
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }

    public void addCrime(Crime crime) {
        this.crimes.add(crime);
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "record='" + record + '\'' +
                ", state='" + state + '\'' +
                ", stateName='" + stateName + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + getSex() + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthdate='" + birthdate + '\n' +
                "Crime=" + crimes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suspect suspect = (Suspect) o;
        return Objects.equals(record, suspect.record);
    }

    @Override
    public int hashCode() {
        return Objects.hash(record);
    }
}

