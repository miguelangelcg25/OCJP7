package collections.maps;

/**
 *
 * @author miguelinux
 */
public class Dog {
    
    private String name;

    public Dog(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Dog){
            return name.equals(((Dog)obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.length();
    }    
    
}
