package i18n;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Migue
 */
public class BundleExample {
    
    public static void main(String[] args) {
        ResourceBundle rbEspanol = ResourceBundle.getBundle("i18n.labels", new Locale("es"));
        ResourceBundle rbEnglish = ResourceBundle.getBundle("i18n.labels", new Locale("en"));
        
        System.out.println(rbEspanol.getString("message"));
        System.out.println(rbEnglish.getString("message"));
    }
    
}
