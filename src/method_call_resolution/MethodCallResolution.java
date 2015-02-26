package method_call_resolution;

/**
 *
 * @author Migue
 */
public class MethodCallResolution {
    
    public void doStuff(Animal animal){
        System.out.println("it's an animal");
    }
    
    public void doStuff(Horse horse){
        System.out.println("it's a horse");
    }
    
    public static void main(String[] args) {
        MethodCallResolution test = new MethodCallResolution();
        Animal animal = new Animal();
        Horse horse = new Horse();
        Animal animalHorse = new Horse();
        
        //overloaded method - method call resolution at compile time based on the reference type
        test.doStuff(animal);
        test.doStuff(horse);
        test.doStuff(animalHorse);
        System.out.println("");
        
        //overrriden method - method call resolution at runtime based on the object type
        animal.whoAmI();
        horse.whoAmI();
        animalHorse.whoAmI();
    }
    
}
