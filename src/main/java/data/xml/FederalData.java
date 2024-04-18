package data.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * FederalData
 *
 * @author Jose L. Navío Mendoza
 */

@XmlRootElement(name = "DatosFederales")
@XmlAccessorType(XmlAccessType.FIELD)
public class FederalData {

    @XmlElement(name = "Sospechoso")
    ArrayList<Suspect> suspects;

    public FederalData() {
    }

    public FederalData(ArrayList<Suspect> suspects) {
        this.suspects = suspects;
    }

    public ArrayList<Suspect> getSuspects() {
        return suspects;
    }

    public void setSuspects(ArrayList<Suspect> suspects) {
        this.suspects = suspects;
    }
}
