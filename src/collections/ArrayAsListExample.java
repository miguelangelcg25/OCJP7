package collections; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author miguelinux
 */
public class ArrayAsListExample {
    
    public static void main(String[] args) {
        String[] array = {"one", "two", "three", "four"};
        List<String> list = Arrays.asList(array);
        
        for(String s: array){
            System.out.print(" " + s + " ");
        }
        System.out.println("\n" + list);
        
        //Arrays.arrayAsList returns a fixed size list backed by the array 
        //(trying to add a new item to the list will result in an 
        //UnsupportedOperationException). When you update one of them, the other 
        //updates automatically
        array[1] = "DOS";
        list.set(2, "TRES");
        
        for(String s: array){
            System.out.print(" " + s + " ");
        }
        System.out.println("\n" + list);
        
        //Nothing fancy about List.toArray, returns an array into which the 
        //elements are stored, if it's big enoguh; otherwise, returns a new 
        //array of the specified type
        list = new ArrayList<>();
        array = new String[2];
        list.add("uno");
        list.add("dos");
        list.add("tres");
        list.add("cuatro");        
        array = list.toArray(array);
        
        array[1] = "TWO";
        list.set(2, "THREE");
        
        for(String s: array){
            System.out.print(" " + s + " ");
        }
        System.out.println("\n" + list);
    }
    
}
