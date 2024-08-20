package org.example;

import java.util.Arrays;

class QuickSort {

    static void quickSort(int[] arr, int indexLow, int indexHigh)
    {
        if (indexLow < indexHigh) {

            int sortedValueIndex = indexLow - 1;

            for (int i = indexLow; i < indexHigh; i++) {
                if (arr[i] < arr[indexHigh]) {
                    sortedValueIndex++;

                    int temp = arr[sortedValueIndex];
                    arr[sortedValueIndex] = arr[i];
                    arr[i] = temp;
                }
            }
            sortedValueIndex++;

            int temp = arr[sortedValueIndex];
            arr[sortedValueIndex] = arr[indexHigh];
            arr[indexHigh] = temp;

            quickSort(arr, indexLow, sortedValueIndex - 1);
            quickSort(arr, sortedValueIndex + 1, indexHigh);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 13, 8, 9, 1, 5, 3 };
        System.out.println("Given array:"  + Arrays.toString(arr)); 

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: " + Arrays.toString(arr)); 
    }
}
