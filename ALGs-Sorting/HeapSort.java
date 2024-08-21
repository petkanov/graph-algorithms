package org.example;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {3, 9, 2, 1, 4, 5, 12, 14, 22, 31};
        System.out.println("Original Array: " + Arrays.toString(array));

        heapSort(array);

        System.out.println("Sorted Array: " + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        // Create Maxheap 
        for (int i = array.length/2; i >= 0; i--) {
            heapify(array, i, array.length);
        }
        
        System.out.println("After Creating Maxheap: " + Arrays.toString(array));

        // Turn into sorted ascending array
        for (int i = array.length-1; i > 0; i--) {

            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, 0, i);
        }
    }

    public static void heapify(int[] array, int elementIndexToHeapify, int maxIndex) {
        int largestElementIndex = elementIndexToHeapify;
        int left = 2 * elementIndexToHeapify + 1;
        int right = 2 * elementIndexToHeapify + 2;

        if (left < maxIndex && array[left] > array[largestElementIndex]) {
            largestElementIndex = left;
        }

        if (right < maxIndex && array[right] > array[largestElementIndex]) {
            largestElementIndex = right;
        }

        if (largestElementIndex != elementIndexToHeapify) {
            int swap = array[elementIndexToHeapify];
            array[elementIndexToHeapify] = array[largestElementIndex];
            array[largestElementIndex] = swap;

            heapify(array, largestElementIndex, maxIndex);
        }
    }
}
