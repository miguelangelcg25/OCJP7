package designpatterns.factory;

/**
 *
 * @author Migue
 */
public class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("Draw Circle");
    }

    @Override
    public void fillColor() {
        System.out.println("Fill Circle");
    }
    
}
