package collection;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.Util;
import bean.Cat;
import bean.Dog;
import bean.Person;

public class PriorityQueueExample {

	public static void main(String[] args) {
		Comparator<Dog> comparator = new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};

		//Dog is not comparable, must pass a comparator
		PriorityQueue<Dog> pq = new PriorityQueue<>(comparator);
		pq.add(new Dog("Huesos"));
		pq.offer(new Dog("Scooby"));
		pq.add(new Dog("Benji"));
		pq.add(new Dog("Goofy"));
		pq.add(new Dog("Goofy"));

		System.out.println(pq);		
		System.out.println(pq.peek());
		System.out.println(pq);
		
		while(pq.isEmpty()){
			System.out.print(pq.poll() + " ");
		}
		
		//person is comparable
		PriorityQueue<Person> persons = new PriorityQueue<>();
		persons.offer(new Person("Migo", Util.toDate("21/10/1989")));
		persons.offer(new Person("Miguelángel", Util.toDate("25/04/1986")));
		persons.offer(new Person("Andreína", Util.toDate("04/09/1983")));
		persons.add(new Person("Angelica", Util.toDate("02/03/1986")));
		
		while(!persons.isEmpty()){
			System.out.println(persons.poll());
		}
		
		// Cat isn't Comparable
		PriorityQueue<Cat> q = new PriorityQueue<>();
		q.add(new Cat("Chatran"));
		q.offer(new Cat("Gato con botas"));
		q.add(new Cat("Bola de nieve"));

	}

}
