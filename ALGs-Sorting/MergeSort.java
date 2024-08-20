import java.io.*;
import java.util.Arrays;

class MergeSort {

    static void merge(int arr[], int leftIndex, int middleIndex, int rightIndex)
    {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        // Create temp arrays
        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        // Copy data to temp arrays
        for (int i = 0; i < leftArraySize; ++i) {
            leftArray[i] = arr[leftIndex + i];
        }
        for (int j = 0; j < rightArraySize; ++j) {
            rightArray[j] = arr[middleIndex + 1 + j];
        }

        // Initial indices of first and second subarrays
        int i = 0;
        int j = 0;

        // Initial index of merged subarray array
        int mergedArrayIndex = leftIndex;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                arr[mergedArrayIndex] = leftArray[i];
                i++;
            }
            else {
                arr[mergedArrayIndex] = rightArray[j];
                j++;
            }
            mergedArrayIndex++;
        }

        // Copy remaining elements of L[] if any
        while (i < leftArraySize) {
            arr[mergedArrayIndex] = leftArray[i];
            i++;
            mergedArrayIndex++;
        }

        // Copy remaining elements of R[] if any
        while (j < rightArraySize) {
            arr[mergedArrayIndex] = rightArray[j];
            j++;
            mergedArrayIndex++;
        }
    }

    // Main function that sorts arr[l..r] using merge()
    static void sort(int arr[], int leftIndex, int rightIndex)
    {
        if (leftIndex < rightIndex) {
            // Find the middle point
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            // Sort first and second halves
            sort(arr, leftIndex, middleIndex);
            sort(arr, middleIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(arr, leftIndex, middleIndex, rightIndex);
        }
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {12,11,13,5,6,7,2,3,1};

        System.out.println("Given array is: " + Arrays.toString(arr)); 

        sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is: " + Arrays.toString(arr)); 
    }
}