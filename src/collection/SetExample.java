package collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import bean.Cat;
import bean.Dog;

public class SetExample {

	public static void main(String... args) {
		// ramdon order, no duplicates allowed
		Set<Dog> hashSet = new HashSet<>();
		hashSet.add(new Dog("Canela"));
		hashSet.add(new Dog("Nicky"));
		hashSet.add(new Dog("Runy"));
		hashSet.add(new Dog("Niko"));
		hashSet.add(new Dog("Niko"));
		hashSet.add(new Dog("Niko"));
		System.out.println(hashSet);

		// ordered by insertion order, no duplicates allowed
		Set<Dog> linkedSet = new LinkedHashSet<>();
		linkedSet.add(new Dog("Canela"));
		linkedSet.add(new Dog("Nicky"));
		linkedSet.add(new Dog("Runy"));
		linkedSet.add(new Dog("Niko"));
		linkedSet.add(new Dog("Niko"));
		linkedSet.add(new Dog("Niko"));
		System.out.println(linkedSet);

		Comparator<Dog> comparator = new Comparator<Dog>() {
			@Override
			public int compare(Dog o1, Dog o2) {
				return o2.getName().compareTo(o1.getName());
				// return o1.getAge() - o2.getAge();
			}
		};

		// Dog isn't comparable, must pass a comparator
		// ordered by comparator/comparable, no duplicates allowed
		// if an item already exists (according to the comparator) then it isn't
		// added
		Set<Dog> treeSet = new TreeSet<>(comparator);
		treeSet.add(new Dog("Canela"));
		treeSet.add(new Dog("Nicky"));
		treeSet.add(new Dog("Runy"));
		treeSet.add(new Dog("Niko"));
		treeSet.add(new Dog("Niko"));
		treeSet.add(new Dog("Niko"));
		System.out.println(treeSet);

		Set<Cat> catSet = new TreeSet<>();
		catSet.add(new Cat("Not comparable"));
	}

}
