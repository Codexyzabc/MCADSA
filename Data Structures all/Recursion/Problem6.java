/*6. Write a Program to implement Binary Search using a recursive function. */

package Recursion;
public class Problem6 {

    
    public static int binarySearch(int[] arr, int low, int high, int key) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            // If the key is present at the middle
            if (arr[mid] == key) {
                return mid;
            }

            // If the key is smaller than the middle element, then it can only be present in the left subarray
            if (arr[mid] > key) {
                return binarySearch(arr, low, mid - 1, key);
            }

            // Else the key can only be present in the right subarray
            return binarySearch(arr, mid + 1, high, key);
        }

        // Key not found
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int key = 14;
        int result = binarySearch(arr, 0, arr.length - 1, key);
        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
