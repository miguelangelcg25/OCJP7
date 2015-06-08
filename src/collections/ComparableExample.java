package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author miguelinux
 */
public class ComparableExample implements Comparable<ComparableExample> {

    private String name;
    
    public static void main(String[] args) {
        String[] array = {"Miguelangel", "Angelica", "Andreina", "Kristian", "Beatriz"};
        List<ComparableExample> list = new ArrayList<>();
        list.add(new ComparableExample("Miguelangel"));
        list.add(new ComparableExample("Angelica"));
        list.add(new ComparableExample("Kristian"));
        list.add(new ComparableExample("Andreina"));
        list.add(new ComparableExample("Beatriz"));
        
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
    
    public ComparableExample(String name){
        this.name = name;
    }
    
    @Override
    public int compareTo(ComparableExample o) {
        return name.compareTo(o.getName());
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
