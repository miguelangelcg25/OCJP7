package designpatterns.factory;

/**
 *
 * @author Migue
 */
public interface Shape {
    
    String CIRCLE = "CIRCLE";
    String RECTANGLE = "RECTANGLE";
    
    public void draw();
    public void fillColor();    
}
