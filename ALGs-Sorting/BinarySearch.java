import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == value) {
                return mid;
            }

            if (arr[mid] < value) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {
        int arr[] = {1,3,4,6,8,13,15,22,29,34};

        System.out.println("Element is at index: " + binarySearch(arr, 13));
    }
}
