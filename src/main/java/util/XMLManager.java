package util;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
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

//    //Read XML
//    public static Usuario readUsuarioXML() {
//
//        Usuario usuario;
//
//        try {
//
//            JAXBContext context = JAXBContext.newInstance(Usuario.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            usuario = (Usuario) unmarshaller.unmarshal(new File(Constants.JOSE_NAVIO_XML_RUTA));
//
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }
//
//        return usuario;
//    }
//
//    public static Pedido readPedidoXML() {
//
//        Pedido pedido;
//
//        try {
//
//            JAXBContext context = JAXBContext.newInstance(Pedido.class);
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            pedido = (Pedido) unmarshaller.unmarshal(new File(Constants.PEDIDO_XML_RUTA));
//
//        } catch (JAXBException e) {
//            throw new RuntimeException(e);
//        }
//
//        return pedido;
//    }
//
//    //Validate XML using XSD - Generate XSD: Oxygen -> Document -> Schema -> Generate
//    public static boolean validateXMLwithXSD(String xmlRoute, String xsdRoute) {
//
//        try {
//            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = factory.newSchema(new File(xsdRoute));
//            Validator validator = schema.newValidator();
//            //StreamSource act as a holder for XML markup
//            validator.validate(new StreamSource(new File(xmlRoute)));
//        } catch (IOException | SAXException e) {
//            System.out.println("Exception: " + e.getMessage());
//            return false;
//        }
//        return true;
//    }
}
