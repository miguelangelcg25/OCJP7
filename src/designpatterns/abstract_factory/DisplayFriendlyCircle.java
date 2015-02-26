package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class DisplayFriendlyCircle implements ShapeDisplayFriendly{

    @Override
    public void draw() {
        System.out.println("Display friendly circle");
    }
    
}
