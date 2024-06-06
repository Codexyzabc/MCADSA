/*7. Write a Program to reverse an array using a recursive function. */

package Recursion;

public class Problem7 {

    
    public static void reverseArray(int[] arr, int start, int end) {
        // Base case: if start index is greater than or equal to end index, return
        if (start >= end) {
            return;
        }
        
        // Swap elements at start and end indices
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        // Recursive call with updated start and end indices
        reverseArray(arr, start + 1, end - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array:");
        printArray(arr);

        reverseArray(arr, 0, arr.length - 1);

        System.out.println("\nReversed array:");
        printArray(arr);
    }

    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

