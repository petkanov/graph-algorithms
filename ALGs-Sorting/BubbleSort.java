

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
        int[] array = {64, 34, 25, 12, 22, 11, 90, 17};
        System.out.println("Unsorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        bubbleSort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
