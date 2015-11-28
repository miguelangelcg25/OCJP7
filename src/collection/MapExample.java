package collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import bean.Dog;

/**
 * Key duplicates are not allowed. Objects used as keys must override equals and
 * hashCode methods.
 * 
 * @author miguelangel
 *
 */
public class MapExample {

	public static void main(String... args) {
		// random order, no duplicates allowed
		Map<Dog, Integer> hashMap = new HashMap<>();
		hashMap.put(new Dog("Canela"), 0);
		hashMap.put(new Dog("Canela"), 0);
		hashMap.put(new Dog("Nicky"), 0);
		hashMap.put(new Dog("Niko"), 0);
		System.out.println(hashMap);

		// ordered by insertion order, no duplicates allowed
		Map<Dog, Integer> linkedMap = new LinkedHashMap<>();
		linkedMap.put(new Dog("Canela"), 0);
		linkedMap.put(new Dog("Canela"), 0);
		linkedMap.put(new Dog("Nicky"), 0);
		linkedMap.put(new Dog("Niko"), 0);
		System.out.println(linkedMap);

		Comparator<Dog> comparator = new Comparator<Dog>() {
			@Override
			public int compare(Dog o1, Dog o2) {
				// return o2.getName().compareTo(o1.getName());
				return o1.getAge() - o2.getAge();
			}
		};
		// ordered by insertion order, no duplicates allowed
		Map<Dog, Integer> treeMap = new TreeMap<>(comparator);
		treeMap.put(new Dog("Canela"), 0);
		treeMap.put(new Dog("Canela"), 0);
		treeMap.put(new Dog("Nicky"), 0);
		treeMap.put(new Dog("Niko"), 0);
		System.out.println(treeMap);
	}

}
