package designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Migue
 */
public class Canvas {
    List<Shape> shapes = new ArrayList<Shape>();
    
    public Canvas(){

    }
    
    public void addNewShape(String shapeType){
        shapes.add(ShapeFactory.getShape(shapeType));
    }
    
    public void draw(){
        for(Shape shape: shapes){
            shape.draw();
        }
    }
    
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.addNewShape(Shape.CIRCLE);
        canvas.addNewShape(Shape.RECTANGLE);
        canvas.draw();
    }
}
