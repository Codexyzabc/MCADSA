/*1. Create a Class Search within that implement two Generic method LinearSearch(),
BinarySearch(). Test your program for different data. */


public class Search<T extends Comparable<T>> {

   
    public <T> int linearSearch(T[] arr, T target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i; // Return the index if found
            }
        }
        return -1; // Return -1 if not found
    }

    // Binary search method
    public <T extends Comparable<T>> int binarySearch(T[] arr, T target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].compareTo(target);
            if (cmp == 0) {
                return mid; // Return the index if found
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Return -1 if not found
    }

    public static void main(String[] args) {
        Search<Integer> search = new Search<>();
        
      
        Integer[] array = {1, 3, 5, 7, 9, 11, 13};

       
        int linearIndex = search.linearSearch(array, 7);
        if (linearIndex != -1) {
            System.out.println("Linear search: Element found at index " + linearIndex);
        } else {
            System.out.println("Linear search: Element not found");
        }

        
        int binaryIndex = search.binarySearch(array, 7);
        if (binaryIndex != -1) {
            System.out.println("Binary search: Element found at index " + binaryIndex);
        } else {
            System.out.println("Binary search: Element not found");
        }
    }
}


/*Linear search: Element found at index 3
Binary search: Element found at index 3 */