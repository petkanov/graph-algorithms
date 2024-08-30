import java.util.Arrays;

class MergeSort {

    static void merge(int arr[], int leftIndex, int middleIndex, int rightIndex)
    {
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;

        int leftArray[] = new int[leftArraySize];
        int rightArray[] = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; ++i) {
            leftArray[i] = arr[leftIndex + i];
        }
        for (int j = 0; j < rightArraySize; ++j) {
            rightArray[j] = arr[middleIndex + 1 + j];
        }

        int l = 0;
        int r = 0;

        int mergedArrayIndex = leftIndex;

        while (l < leftArraySize && r < rightArraySize) {
            if (leftArray[l] <= rightArray[r]) {
                arr[mergedArrayIndex] = leftArray[l];
                l++;
            }
            else {
                arr[mergedArrayIndex] = rightArray[r];
                r++;
            }
            mergedArrayIndex++;
        }

        while (l < leftArraySize) {
            arr[mergedArrayIndex] = leftArray[l];
            l++;
            mergedArrayIndex++;
        }

        while (r < rightArraySize) {
            arr[mergedArrayIndex] = rightArray[r];
            r++;
            mergedArrayIndex++;
        }
    }

    static void sort(int arr[], int leftIndex, int rightIndex)
    {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            sort(arr, leftIndex, middleIndex);
            sort(arr, middleIndex + 1, rightIndex);

            merge(arr, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void main(String args[])
    {
        int arr[] = {12,11,13,5,6,7,2,3,1};
        System.out.println("Given array is: " + Arrays.toString(arr)); 

        sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array is: " + Arrays.toString(arr)); 
    }
}