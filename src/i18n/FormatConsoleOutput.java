package i18n;

/**
 *
 * @author Migue
 */
public class FormatConsoleOutput {
    
    public static void main(String[] args) {
        int a = 123456;
        int b = -876;
        double c = 8723.4556;
        
        System.out.format("%1$,10.2f %2$0+10d %3$+10d", c, b, a);
        System.out.println("");
    }
}
