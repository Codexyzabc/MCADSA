package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        
        System.out.println("Initially elements are: ");
        printArray(arr);
        
        mergeSort(arr);
        
        System.out.println("\nFinally elements are: ");
        printArray(arr);
    }

    static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
            int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);
            
            mergeSort(leftArray);
            mergeSort(rightArray);

            int i = 0, j = 0, k = 0;

            while (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] < rightArray[j]) {
                    arr[k++] = leftArray[i++];
                } else {
                    arr[k++] = rightArray[j++];
                }
            }

            while (i < leftArray.length) {
                arr[k++] = leftArray[i++];
            }

            while (j < rightArray.length) {
                arr[k++] = rightArray[j++];
            }
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
