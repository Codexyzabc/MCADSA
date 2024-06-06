package Sorting;

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Radix_sort sorter = new Radix_sort();
        sorter.sort(arr);
        
        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        scanner.close();
    }
}

class Radix_sort {
    static int findmax(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void countsort(int[] arr, int place) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / place) % 10]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int idx = count[(arr[i] / place) % 10] - 1;
            output[idx] = arr[i];
            count[(arr[i] / place) % 10]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    void sort(int[] arr) {
        int max = findmax(arr);
        for (int place = 1; max / place > 0; place *= 10) {
            countsort(arr, place);
        }
    }
}

