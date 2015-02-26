package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class PrinterFriendlyCircle implements ShapePrinterFriendly{

    @Override
    public void draw() {
        System.out.println("Printer Friendly Circle");
    }
    
}
