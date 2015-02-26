package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public abstract class ShapeDisplayFriendlyFactory implements Shape{
    
    public static Shape getShape(String shapeType){
        switch(shapeType){
            default:
                return null;
            case Shape.CIRCLE:
                return new DisplayFriendlyCircle();
            case Shape.RECTANGLE:
                return new DisplayFriendlyRectangle();
        }
    }
    
}
