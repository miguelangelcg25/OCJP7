package collections.maps;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author miguelinux
 */
public class MapsExample {class Animal{}
    
    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        Dog dog = new Dog("Niko");
        
        map.put(dog, "Perro");
        map.put(new Cat(), "Gato");
        
        //When using objects as key you must override equals and hashCode if you
        //want to find your stuff!!!
        System.out.println(map.get(dog));
        System.out.println(map.get(new Cat()));
        
        //Careful!!! if you want to find your stuff in a map don't change attributes 
        //values used to calculate hashCode or used to check equals
        dog.setName("Polita");
        System.out.println(map.get(dog));        
    }
}
