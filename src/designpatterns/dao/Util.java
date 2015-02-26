package designpatterns.dao;

/**
 *
 * @author Migue
 */
public class Util {
    
    private static boolean testMode = true;

    public static boolean isTestMode() {
        return testMode;
    }

    public static void setTestMode(boolean newTestMode) {
        testMode = newTestMode;
    }
    
}
