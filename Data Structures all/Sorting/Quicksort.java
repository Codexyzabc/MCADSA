package Sorting;

import java.util.Scanner;

public class Quicksort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter no of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Initially elements are: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nFinally elements are: ");
        printArray(arr);

        scanner.close();
    }

    static int[] quickSort(int arr[], int first, int last) {
        if (first < last) {
            int p = partition(arr, first, last);
            quickSort(arr, first, p - 1);
            quickSort(arr, p + 1, last);
        }
        return arr;
    }

    static int partition(int arr[], int first, int last) {
        int loc = first;
        int left = first + 1;
        int right = last;
        while (left <= right) {
            while (left <= right && arr[left] <= arr[loc]) {
                left++;
            }

            while (left <= right && arr[right] > arr[loc]) {
                right--;
            }

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        int temp = arr[loc];
        arr[loc] = arr[right];
        arr[right] = temp;
        return right;
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

