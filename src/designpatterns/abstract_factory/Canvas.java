package designpatterns.abstract_factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Migue
 */
public class Canvas {
    List<Shape> shapes = new ArrayList<>();
    
    public void addNewShape(String shapeType, String mode){
        shapes.add(ShapeFactory.getShape(shapeType, mode));
    }
    
    public void drawAllShapes(){
        for(Shape shape: shapes){
            shape.draw();
        }
    }
    
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.addNewShape(Shape.CIRCLE, Shape.DISPLAY_FRIENDLY);
        canvas.addNewShape(Shape.RECTANGLE, Shape.PRINTER_FRIENDLY);
        canvas.drawAllShapes();
    }
}
