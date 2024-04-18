package data.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Crime
 *
 * @author Jose L. Navío Mendoza
 */
@XmlRootElement(name = "Delito")
@XmlAccessorType(XmlAccessType.FIELD)
public class Crime {
    @XmlElement(name = "Fecha")
    String date;
    @XmlElement(name = "Tipo")
    String type;
    @XmlElement(name = "Observaciones")
    String observation;

    public Crime() {
    }

    public Crime(String date, String type, String observation) {
        this.date = date;
        this.type = type;
        this.observation = observation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Crime{" + "date=" + date + ", type=" + type + ", observation=" + observation + '}';
    }

}
