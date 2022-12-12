package com.cse.ds.sorting;

import java.util.Arrays;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/22/19
 * File: Heap.java 
 */

/**
 * This file includes the StringHeap class which implements the Heap data 
 * structure. The Heap data structure is based off a tree with the top called 
 * the root and the left and right nodes extending off it called the child.
 */

/**
 * This class is the Heap class which implements the Heap data structure. This 
 * class specifically sorts the String objects in the Heap. Included below are 
 * methods to remove the root from the Heap and order the Heap.
 */

public class StringHeap {
	
	private String[] data;
	private int last_idx;

    /** 
     * Constructor for StringHeap object
     *
     * @param none
     * @return    StringHeap object
     */

	public StringHeap() {
		data = new String[1];
		last_idx = 0;
	}
	
	/**
	 * Create a heap out of an array of Strings.
	 * @param arr
	 */
	public StringHeap(String arr[]) {
        // if arr is null, throw an exception
        if(arr == null) {
            throw new IllegalArgumentException();
        }

        // if any value in arr is null, throw an exception
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                throw new IllegalArgumentException();
            }
        }

        // create a new array with 1 more than the given arr      
		this.data = new String[arr.length + 1];

        // set the first element in the array to null
        data[0] = null;

        // copy all the elements in arr to the array of the Heap object
        for(int i = 1; i < arr.length + 1; i++) {
            data[i] = arr[i - 1];
        }

        // set last index of the Heap to the length of arr
        this.last_idx = arr.length;

        // sort the Heap
        for(int i = data.length / 2; i >= 1; i--) {
            heapify(i);
        }
	}
	
	/**
	 * This corrects a single violation at position i, if left and right 
	 * subtrees are max heaps.
	 * @param i
	 */

	public void heapify(int i) {
        // if i greater than last index, throw an exception
		if(i > this.last_idx) { 
            throw new IllegalArgumentException("Cannot Heapify index greater" +
                    " than heap size.");
        }

        // if i is negative, throw an exception
        if(i < 0) { 
            throw new IllegalArgumentException();
        }

        // set the index of the left and right child
        int left = 2 * i;
        int right = left + 1;
        int largest = 0;

        // if left index is less than or equal to the last index, left is less
        // than the size of the array, and the priority of the left is higher
        // than the priority of the parent       
        if(left <= this.getSize() && left < this.data.length && 
                this.data[left].compareTo(this.data[i]) > 0) {
            // set largest to left
            largest = left;
        }
        else {
            largest = i;
        }
        
        // if right index is less than or equal to the last index, right is less
        // than the size of the array, and the priority of the right is higher
        // than the priority of the parent
        if(right <= this.getSize() && right < this.data.length && 
                this.data[right].compareTo(this.data[largest]) > 0) {
            // set largest to right
            largest = right;
        }

        // if largest is not equal to i
        if(largest != i) {
            // switch i and largest
            String temp = this.data[i];
            this.data[i] = this.data[largest];
            this.data[largest] = temp;

            // heapify at the new largest
            heapify(largest);
        }
	}
	
	/**
	 * This function returns the max element from the heap without removing 
	 * the element from heap.
	 * @return
	 */
	public String getMax() {
        // if Heap is empty, return null
		if(this.last_idx == 0) {
		    return null;
        }

        // return root node
        return this.data[1];
	}
	
	/**
	 * This function removes and returns the max element from the heap
	 * @return
	 */
	public String heappop() {
        // if Heap is empty, return null
		if(this.last_idx < 1) {
		    return null;
        }
        
        // store element to return
		String toReturn = this.getMax();

        // create an empty String
        String newString = "";

        // switch the root node and the node at the end of the Heap
        this.data[1] = this.data[this.last_idx];

        // set the node at the end to the empty String
        this.data[this.last_idx] = newString;

        // heapify at the root
        heapify(1);

        // decrement the last index
        this.last_idx--;
		return toReturn;
	}
	
	/**
	 * This function returns the size of the heap.
	 * @return
	 */
	public int getSize() {
		return this.last_idx;
	}
	
    /**
     * String format of the heap
     *
     * @param none
     * @return    String format of the heap
     */  

	@Override
	public String toString() {
		return Arrays.toString(data);
	}
}
