package collection;

import java.util.Comparator;
import java.util.PriorityQueue;

import bean.Cat;
import bean.Dog;

public class PriorityQueueExample {

	public static void main(String[] args) {
		Comparator<Dog> comparator = new Comparator<Dog>() {

			@Override
			public int compare(Dog o1, Dog o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		PriorityQueue<Dog> pq = new PriorityQueue<>(comparator);
		pq.add(new Dog("Huesos"));
		pq.offer(new Dog("Scooby"));
		pq.add(new Dog("Benji"));
		pq.add(new Dog("Goofy"));

		// random order
		System.out.println(pq);		
		System.out.println(pq.peek());
		System.out.println(pq);
		
		while(pq.isEmpty()){
			System.out.print(pq.poll() + " ");
		}
		
		// Cat isn't Comparable
		PriorityQueue<Cat> q = new PriorityQueue<>();
		q.add(new Cat("Chatran"));
		q.offer(new Cat("Gato con botas"));
		q.add(new Cat("Bola de nieve"));

	}

}
