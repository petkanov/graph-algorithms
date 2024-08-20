import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array) {

        boolean swapped;
        for (int i = 0; i < array.length - 1; i++) {

            swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {

                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90, 1, 5, 7, 17};
        System.out.println("Unsorted array: " + Arrays.toString(array)); 

        bubbleSort(array);

        System.out.println("Sorted array: " + Arrays.toString(array)); 
    }
}
