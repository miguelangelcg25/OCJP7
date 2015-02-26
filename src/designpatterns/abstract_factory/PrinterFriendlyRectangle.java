package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class PrinterFriendlyRectangle implements ShapePrinterFriendly{

    @Override
    public void draw() {
        System.out.println("Printer Friendly Rectangle");
    }
    
}
