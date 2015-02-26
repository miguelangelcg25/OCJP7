package designpatterns.abstract_factory;

/**
 *
 * @author Migue
 */
public class DisplayFriendlyRectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Display friendly rectangle");
    }
        
}
