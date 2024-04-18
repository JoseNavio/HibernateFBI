package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utils
 *
 * @author Jose L. Navío Mendoza
 */

public class Utils {

        public static String imageToBase64(String imageName) {

            String imagePath = "src/main/resources/" + imageName + ".png";

            try {
                byte[] imageBytes = Files.readAllBytes(Paths.get(imagePath));
                return java.util.Base64.getEncoder().encodeToString(imageBytes);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String generateToken(String cadena) {
            java.util.Base64.Encoder base64Encoder = java.util.Base64.getUrlEncoder();
            byte[] randomBytes = cadena.getBytes();
            return base64Encoder.encodeToString(randomBytes);
        }
}
