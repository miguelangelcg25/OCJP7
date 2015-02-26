package designpatterns.factory;

/**
 *
 * @author Migue
 */
public class ShapeFactory {
    
    public static Shape getShape(String shapeType){
        switch(shapeType){
            case Shape.CIRCLE:
                return new Circle();
            case Shape.RECTANGLE:
                return new Rectangle();
        }
        return null;
    }
    
}
