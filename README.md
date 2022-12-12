Author: Julian Yan  
Date: 5/22/2019  
Title: Triage Facility  
Summary: This program implements heap to aid the order in a triage facility.

Contents: 
* src
  * main
    * heaps
      * Heap.java
        * This file includes a class which implements the Heap data structure.
          * Heap()
          * Heap(Tuple arr[])
          * void heapify(int i)
          * Tuple getMax()
          * Tuple heappop()
          * void increasePriority(int i, int priority)
          * heappush(Tuple arg)
          * int getSize()
          * String toString()
      * HeapSortGeneric.java
        * This file includes a class which uses the methods in the Heap class to sort objects.
          * HeapSortGeneric(E[] data, int[] priority)
          * E[] sort(boolean ascending)
      * Tuple.java 
        * This file includes a class that acts a Tuple class.
          * Tuple(int priority, E value)
          * String toString()
    * hospital
      * TriageFacility.java
        * This file includes a class which mimicks a hospital where patients are served based on the priority of their needs.
          * TriageFacility(String[] patients)
          * String serviceNextPatient()
          * void addNewPatient(String patient)
          * int getTriageLength()
    * sorting
      * HeapSortString.java
        * This file includes a class which uses the methods in the StringHeap class to sort objects.
          * void sort(String[] array, boolean ascending)
      * Sorting.java
        * This file includes the Sorting interface.
          * void sort(T[] array, boolean ascending)
          * void swap(T array[],int i,int j)
          * void print(T array[])
      * StringHeap.java
        * This file includes a class which implements the Heap data structure.
          * StringHeap()
          * StringHeap(String arr[])
          * void heapify(int i)
          * String getMax()
          * String heappop() 
          * int getSize()
          * String toString()
   * test
     * GenericTest.java