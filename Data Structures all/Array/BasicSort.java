/*2. Create a Class BasicSort within that implement three Generic methods that can implement the
BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data. */

public class BasicSort {
    public static <T extends Comparable<T>> T[] bubbleSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static <T extends Comparable<T>> T[] selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    public static void main(String[] args) {
       
        Integer[] intArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(intArr);
        System.out.println("Bubble sorted array:");
        
        Integer array1[]= bubbleSort(intArr);
        printArray(array1);
        System.out.println("Selection sorted array:");
        Integer array2[]= selectionSort(intArr);
        printArray(array2);
        System.out.println("Insertion sorted array:");
        Integer array3[]= insertionSort(intArr);
        printArray(array3);

       
        String[] strArr = {"banana", "apple", "orange", "grape", "pineapple"};
        System.out.println("\nOriginal array:");
        printArray(strArr);
        System.out.println("Bubble sorted array:");
        String array4[]= bubbleSort(strArr);
        printArray(array4);
        System.out.println("Selection sorted array:");
        String array5[]= selectionSort(strArr);
        printArray(array5);
        System.out.println("Insertion sorted array:");
        String array6[]= insertionSort(strArr);
        printArray(array6);
    }

    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}


/*Original array:
64 34 25 12 22 11 90
Bubble sorted array:
11 12 22 25 34 64 90
Selection sorted array:
11 12 22 25 34 64 90
Insertion sorted array:
11 12 22 25 34 64 90

Original array:
banana apple orange grape pineapple
Bubble sorted array:
apple banana grape orange pineapple
Selection sorted array:
apple banana grape orange pineapple
Insertion sorted array:
apple banana grape orange pineapple */
