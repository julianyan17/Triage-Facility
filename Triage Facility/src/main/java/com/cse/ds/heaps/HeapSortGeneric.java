package com.cse.ds.heaps;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/22/19
 * File: HeapSortGeneric.java 
 */

/**
 * This file includes the HeapSortGeneric class which uses the methods in the 
 * Heap class to sort objects. This means that the objects are sorted using
 * the Heap data structure.
 */

/**
 * This class includes methods to sort the objects passed into the 
 * HeapSortGeneric constructor. In order to be to able to sort the objects, 
 * the methods from the Heap class are called.
 */

public class HeapSortGeneric<E> {
	
	private E[] data;
	private int[] priority;
	
    /**
     * Constructor for HeapSortGeneric object
     *
     * @param data 
     * @param priority 
     * @return         HeapSortGeneric object
     */
    
    public HeapSortGeneric(E[] data, int[] priority) {
        this.data = data;
        this.priority = priority;
	}
	
	/**
	 * This method sorts the value and returns a new array
	 * @param ascending
	 * @return         sorted array
	 */

	public E[] sort(boolean ascending) {

        // create a new Tuple array
		Tuple newArr[] = new Tuple[data.length];

        // copy all from the data array into the new Tuple array
        for(int i = 0; i < data.length; i++) {
            newArr[i] = new Tuple(priority[i],data[i]);
        }

        // create a new Heap with the new array
        Heap newHeap = new Heap(newArr);
        
        // create an array to return
        E[] toReturn = (E[]) new Object[data.length];

        // pop the entire Heap to get the elements in descending order
        for(int i = 0; i < data.length; i++) {
            toReturn[i] = (E)newHeap.heappop().value;
        }

        // reverse the order of the array to return
        if(ascending == true) { 
            // reverse method
            for(int i = 0; i < data.length / 2; i++) {
                E temp = toReturn[i];
                toReturn[i] = toReturn[data.length - i - 1];
                toReturn[data.length - i - 1] = temp;
            }
        }
		return toReturn;
	}
}
