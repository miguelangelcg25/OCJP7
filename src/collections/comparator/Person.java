package collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author miguelinux
 */
public class Person {

    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            return id == ((Person) o).getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }

    static class PersonComparators {

        final static Comparator<Person> orderById = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId() - o2.getId();
            }
        };

        final static Comparator<Person> orderByName = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }

        };

        final static Comparator<Person> orderByAge = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }

        };
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Miguelangel", 29));
        list.add(new Person(3, "Angelica", 29));
        list.add(new Person(2, "Kristian", 26));
        list.add(new Person(4, "Daniela", 28));

        Person person = new Person(3, "Angelica", 29);
        Collections.sort(list, PersonComparators.orderByName);
        System.out.println(list);
        int index = Collections.binarySearch(list, person, PersonComparators.orderByName);
        System.out.println(list.get(index));
        System.out.println(person.equals(list.get(index)));

        //you MUST sort your list before searching, and must override equals() 
        //method or the results will be unexpected.
        Collections.sort(list, PersonComparators.orderById);
        System.out.println(list);
        index = Collections.binarySearch(list, person, PersonComparators.orderById);
        System.out.println(list.get(index));
        System.out.println(person.equals(list.get(index)));

        //If the list contains multiple elements equal to the specified object,
        //there is no guarantee which one will be found. 
        Collections.sort(list, PersonComparators.orderByAge);
        System.out.println(list);
        index = Collections.binarySearch(list, person, PersonComparators.orderByAge);
        System.out.println(list.get(index));
        System.out.println(person.equals(list.get(index)));
        
        //Whenever you want a collection sorted, its elements must be mutually
        //comparable. Unless specified, objects of diferent types are not comparable
        List newList = new ArrayList();
        newList.add("String");
        newList.add(100);
        newList.add(person);
        
        //newList.sort(PersonComparators.orderById);    //ClassCastException will be thrown
    }
}
