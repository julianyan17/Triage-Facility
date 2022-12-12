package com.cse.ds.heaps;

import java.util.Arrays;

/**
 * Author: Julian Wai San Yan 
 * Date: 5/22/19
 * File: Heap.java 
 */

/**
 * This file includes the Heap class which implements the Heap data structure.
 * The Heap data structure is based off a tree with the top called the root and 
 * the left and right nodes extending off it called the child.
 */

/**
 * This class is the Heap class which implements the Heap data structure.
 * Included below are methods to add to the Heap, remove the root from the Heap
 * change the priority of the Heap and order the Heap.
 */

public class Heap {
	
	private Tuple[] data; //This stores data in accoradance with heap rules.
	private int last_idx; //This keeps track of last index where an element was 
                          //inserted.

    /**
     * Constructor for a Heap object
     *
     * @param none
     * @return    Heap object
     */

	public Heap() {
		data = new Tuple[1];
		last_idx = 0;
	}
	
	/**
	 * Create a heap out of an array of Tuples.
	 * @param arr
	 */

	public Heap(Tuple arr[]) {
        // create a new array with 1 more than the given arr
		this.data = new Tuple[arr.length + 1];

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
                this.data[left].priority > this.data[i].priority) {
            // set largest to left
            largest = left;
        }
        else {
            // set largest to i
            largest = i;
        }

        // if right index is less than or equal to the last index, right is less
        // than the size of the array, and the priority of the right is higher
        // than the priority of the parent
        if(right <= this.getSize() && right < this.data.length && 
                this.data[right].priority > this.data[largest].priority) {
            // set largest to right
            largest = right;
        }

        // if largest is not equal to i 
        if(largest != i) {
            // switch i and largest
            Tuple temp = this.data[i];
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

	public Tuple getMax() {
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
	public Tuple heappop() {
        // if Heap is empty, return null
		if(this.last_idx == 0) {
		    return null;
        }
        
        // store element to return 
		Tuple toReturn = this.getMax();

        // create a new Tuple with the smallest number and a null value
        Tuple newTuple = new Tuple(Integer.MIN_VALUE,null);

        // switch the root node and the node at the end of the Heap
        this.data[1] = this.data[this.last_idx];

        // set the node at the end with the null Tuple
        this.data[this.last_idx] = newTuple;

        // heapify at the root 
        heapify(1);

        // decrement index
        this.last_idx--;

		return toReturn;
	}
	
	/**
	 * This function increases the priority of a node.
	 * @param i
	 * @param priority
	 */

	public void increasePriority(int i, int priority) {
        // if the priority at i is greater than the given priority, throw an
        // exception
		if(this.data[i].priority > priority) {
            throw new IllegalArgumentException("Priority less than Current");
        }

        // create a new Tuple with the priority and value of element at i
        Tuple newTuple = new Tuple(priority, this.data[i].value);

        // set the element at i to the newTuple
        this.data[i] = newTuple;

        // go through the Heap from the bottom and sort the elements
        while(i > 1 && this.data[i/2].priority < this.data[i].priority) {
            // switch the parent and the child
            Tuple temp = this.data[i];
            this.data[i] = this.data[i/2];
            this.data[i/2] = temp; 
            i = i/2;
        }
	}
	
	/**
	 * This function pushes a new element in the heap
	 * @param arg
	 */

	public void heappush(Tuple arg) {
        // if arg is null or value of arg is null, throw an exception
        if(arg == null || arg.value == null) {
            throw new IllegalArgumentException();
        }

        // increase the size of the array if there is no room
		if(this.last_idx == this.data.length - 1) {
            Tuple[] newArr = new Tuple[this.data.length + 1];
            for(int i = 0; i < this.last_idx + 1; i++) {
                newArr[i] = this.data[i];
            }
            this.data = newArr;
        }

        // increment last index
        this.last_idx++;

        // add new element to the Heap
        this.data[this.last_idx] = new Tuple(Integer.MIN_VALUE, arg.value);

        // increase the priority of the new element from the bottom of the Heap
        // and up
        increasePriority(this.last_idx, arg.priority);
	}
	
	/**
	 * This function returns the size of the heap.
     *
	 * @return size of the heap
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
