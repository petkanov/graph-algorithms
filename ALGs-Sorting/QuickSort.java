package org.example;

class QuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int separateElements(int[] arr, int indexLow, int indexHigh)
    {
        int separatorIndex = indexLow - 1;

        for (int i = indexLow; i < indexHigh; i++) {
            if (arr[i] < arr[indexHigh]) {
                separatorIndex++;

                swap(arr, separatorIndex, i);
            }
        }
        separatorIndex++;

        swap(arr, separatorIndex, indexHigh);

        return separatorIndex;
    }

    static void quickSort(int[] arr, int indexLow, int indexHigh)
    {
        if (indexLow < indexHigh) {

            int sortedValueIndex = separateElements(arr, indexLow, indexHigh);

            quickSort(arr, indexLow, sortedValueIndex - 1);
            quickSort(arr, sortedValueIndex + 1, indexHigh);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Given array:");
        printArr(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArr(arr);
    }
    
    public static void printArr(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
