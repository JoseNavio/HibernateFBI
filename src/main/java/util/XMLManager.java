package util;

import data.xml.Crime;
import data.xml.FederalData;
import data.xml.Suspect;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * JAXBManager
 *
 * @author Jose L. Navío Mendoza
 */

public class XMLManager {

    //Read XML
    public static FederalData readFBIXML(String xmlRoute) {

        FederalData federalData;

        try {

            JAXBContext context = JAXBContext.newInstance(FederalData.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            federalData = (FederalData) unmarshaller.unmarshal(new File(xmlRoute));

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return federalData;
    }

    /**
     * Validate XML using XSD - Generate XSD: Oxygen -> Document -> Schema -> Generate
     *
     * @param xmlRoute
     * @param xsdRoute
     * @return boolean
     */
    public static boolean validateXMLwithXSD(String xmlRoute, String xsdRoute) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdRoute));
            Validator validator = schema.newValidator();
            //StreamSource act as a holder for XML markup
            validator.validate(new StreamSource(new File(xmlRoute)));
        } catch (IOException | SAXException e) {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
        return true;
    }
}
