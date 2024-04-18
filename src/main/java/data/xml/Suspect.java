package data.xml;

import javax.xml.bind.annotation.*;
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
    @XmlAttribute(name = "nombreEstado")
    String state;
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
    Crime crime;

    public Suspect() {
    }

    public Suspect(String record, String state, String name, String sex, int height, int weight, String birthdate, String photo, Crime crime) {
        this.record = record;
        this.state = state;
        this.name = name;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
        this.birthdate = birthdate;
        this.photo = photo;
        this.crime = crime;
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

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
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

    public Crime getCrime() {
        return crime;
    }

    public void setCrime(Crime crime) {
        this.crime = crime;
    }

    @Override
    public String toString() {
        return "Suspect{" +
                "record='" + record + '\'' +
                ", state='" + state + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", birthdate='" + birthdate + '\n' +
                "Crime=" + crime +
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
