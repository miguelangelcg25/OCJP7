package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class ShapePrinterFriendlyFactory {
    
    public static Shape getShape(String shapeType){
        switch(shapeType){
            default: 
                return null;
            case Shape.CIRCLE:
                return new PrinterFriendlyCircle();
            case Shape.RECTANGLE:
                return new PrinterFriendlyRectangle();
        }
    }
}
