package com.cse.ds.hospital;

import com.cse.ds.heaps.Heap;
import com.cse.ds.heaps.Tuple;

/**
 * Author: Julian Wai San Yan
 * Date: 5/22/19
 * File: Heap.java
 */

/**
 * This file includes the TriageFacility class which mimicks a hospital where
 * patients are served based on the priority of their needs. This means that a
 * Heap is implemented in order to fit this implementation.
 */

/**
 * This class includes method to create a TirageFacility object which creates 
 * the heap. It also includes methods to serve the first patient and add a new
 * patient.
 */

public class TriageFacility {
	
	private Heap heap;
	
    /** 
     * Constructor for TriageFacility object
     *
     * @param none
     * @return    TriageFacility object
     */
    
	public TriageFacility(String[] patients) {
        // if arr is null, throw an exception
        if(patients == null) {
            throw new IllegalArgumentException();
        }

        // if any value in arr is null, throw an exception
        for(int i = 0; i < patients.length; i++) {
            if(patients[i] == null) {
                throw new IllegalArgumentException();
            }
        }
        
        // initialize Heap
        heap = new Heap();

        // get the value and priority of each patient in inputted array
		for(int i = 0; i < patients.length; i++) {
            // get the name of the patient
            String value = patients[i].substring(0,patients[i].indexOf(":"));

            // get the priority of the patient by subtracting from 95
            int priority = Math.abs(95 - (Integer.parseInt(patients[i].
                        substring(patients[i].indexOf(":") + 1, 
                            patients[i].length()))));

            // create a Tuple using patient's name and priority
            Tuple addTo = new Tuple(priority,value);

            // add to Heap
            heap.heappush(addTo);
        }
	}

    /**
     * Remove and return the patient with the highest priority
     *
     * @param none
     * @return    name of patient with highest priority
     */

	public String serviceNextPatient() {
        // if Heap is empty, return null
		if(heap.getSize() == 0) {
		    return null;
        }

        // remove and return the patient
        return (String)(heap.heappop().value);
	}

    /**
     * Add a new patient to the Heap
     *
     * @param patient
     * @return       none
     */

	public void addNewPatient(String patient) {
        // get the name of the patient
        String value = patient.substring(0,patient.indexOf(":"));

        // get the priority of the patient by subtracting from 95        
        int priority = Math.abs(Integer.parseInt(patient.
                    substring(patient.indexOf(":") + 1, patient.length())));

        // create a new Tuple with patient's name and priority
        Tuple addTo = new Tuple(priority,value);

        // add to Heap
        heap.heappush(addTo);		
	}
	
    /**
     * Return the length of the Triage
     *
     * @param none 
     * @return    int 
     */

	public int getTriageLength() {
		return heap.getSize();
	}
}
