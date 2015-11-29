package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysCollectionsExample {
	
	public static void main(String[] args){
		Integer[] array = {6, 1, 4, 3, 2};
		
		//the array must sorted or binary search will return unexpected results
		System.out.println(Arrays.binarySearch(array, 3));
		Arrays.sort(array);
		System.out.println("3 at position " + Arrays.binarySearch(array, 3));
		
		//the resulting list is backed by the array, thus, 
		//you can't add/remove items from the list
		//won't work the same with an array of primitives
		List<Integer> integers = Arrays.asList(array);
		integers.set(0, -9);
		//integers.add(-8);	//throws UnsuportedOperationException
		System.out.println(integers);
		
		for(int i=0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(3);
		list.add(6);
		//Collections.sort and Collections.binarySearch it's the same
		
		Object[] objectArray = list.toArray();
		System.out.print("\nas object array = " + objectArray.length);
		
		Integer[] integerArray = new Integer[list.size()];
		integerArray = list.toArray(new Integer[0]);
		System.out.println("\nas integer array = " + integerArray.length);
		
	}

}
