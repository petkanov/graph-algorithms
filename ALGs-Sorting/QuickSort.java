package org.example;

class QuickSort {
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int needle = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                needle++;
                swap(arr, needle, j);
            }
        }
        swap(arr, needle + 1, high);
        return (needle + 1);
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args)
    {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Given array:");
        printArr(arr);

        int N = arr.length;

        quickSort(arr, 0, N - 1);

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
