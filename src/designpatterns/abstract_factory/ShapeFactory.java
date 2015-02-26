package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class ShapeFactory {
    
    public static Shape getShape(String shapeType, String mode){
        switch(mode){
            case Shape.DISPLAY_FRIENDLY:
                return ShapeDisplayFriendlyFactory.getShape(shapeType);
            case Shape.PRINTER_FRIENDLY:
                return ShapePrinterFriendlyFactory.getShape(shapeType);
            default:
                return null;
        }
        
    }
}
