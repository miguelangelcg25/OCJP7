package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public interface Shape {
    
    String CIRCLE = "CIRCLE";
    String RECTANGLE = "RECTANGLE";
    String PRINTER_FRIENDLY = "PRINTER_FRIENDLY";
    String DISPLAY_FRIENDLY = "DISPLAY_FRIENDLY";

    public void draw();
    
}
