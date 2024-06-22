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
        int n = array.length;

        // Create Maxheap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Turn into Minheap
        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }
}
