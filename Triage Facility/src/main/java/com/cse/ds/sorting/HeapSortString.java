package com.cse.ds.sorting;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/22/19
 * File: HeapSortString.java 
 */

/**
 * This file includes the HeapSortString class which uses the methods in the 
 * StringHeap class to sort objects. This means that the objects are sorted 
 * using the Heap data structure.
 */

/**
 * This class includes methods to sort the objects passed into the 
 * HeapSortString constructor. In order to be to able to sort the objects, 
 * the methods from the StringHeap class are called.
 */
public class HeapSortString implements Sorting<String> {
	
    /**
	 * This method sorts the values in the array
	 * @param array
     * @param ascending
	 * @return          none
	 */	

	@Override
	public void sort(String[] array, boolean ascending) {
        // create a new Heap using the array
        StringHeap newHeap = new StringHeap(array);
        
        // pop the entire Heap to get the elements in descending order
        for(int i = 0; i < array.length; i++) {
            array[i] = newHeap.heappop();
        }

        // reverse the order of the array to return
        if(ascending == true) { 
            // reverse method
            for(int i = 0; i < array.length / 2; i++) {
                String temp = array[i];
                array[i] = array[array.length - i - 1];
                array[array.length - i - 1] = temp;
            }
        }
	}
}
