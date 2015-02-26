package designpatterns.factory;

/**
 *
 * @author Migue
 */
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw Rectangle");
    }

    @Override
    public void fillColor() {
        System.out.println("Fill Rectangle");
    }
    
    
}
