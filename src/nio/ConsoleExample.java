package nio;

import java.io.Console;

/**
 * Console class offers non echoed input
 * System.console returns null if executed from an IDE
 * @author miguelangel
 */
public class ConsoleExample {
    
    public static void main(String[] args) {
        Console c = System.console();
        String user = c.readLine("%s", "User name:");
        char[] password = c.readPassword("%s", "password:");
    }
}
