package org.example;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] array = {3, 9, 2, 1, 4, 5, 12, 14, 22, 31};
        System.out.println("Original Array: " + Arrays.toString(array));

        buildMaxHeap(array);

        System.out.println("Max/Min-Heap Array: " + Arrays.toString(array));
    }

    public static void buildMaxHeap(int[] array) {
        // Create Maxheap
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }

        // Turn into Minheap
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int maxIndex, int i) {
        int largestElementIndex = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < maxIndex && array[left] > array[largestElementIndex]) {
            largestElementIndex = left;
        }

        if (right < maxIndex && array[right] > array[largestElementIndex]) {
            largestElementIndex = right;
        }

        if (largestElementIndex != i) {
            int swap = array[i];
            array[i] = array[largestElementIndex];
            array[largestElementIndex] = swap;

            heapify(array, maxIndex, largestElementIndex);
        }
    }
}
