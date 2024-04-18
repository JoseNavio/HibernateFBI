package util;

/**
 * Constants
 *
 * @author Jose L. Navío Mendoza
 */

public class Constants {

    public static final String SOSPECHOSOS_01_SQL;
    public static final String SOSPECHOSOS_02_SQL;
    public static final String SOSPECHOSOS_XSD;
    public static final String FBI_SQL;

    //Initialize the constant in memory before the classes are loaded
    static {
        FBI_SQL = "src/main/resources/FBI.sql";
        SOSPECHOSOS_01_SQL = "src/main/resources/sospechosos01.xml";
        SOSPECHOSOS_02_SQL = "src/main/resources/sospechosos02.xml";
        SOSPECHOSOS_XSD = "src/main/resources/sospechosos.xsd";
    }
}
