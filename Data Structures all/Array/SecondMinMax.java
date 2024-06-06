/*3. Write a Generic method that computes the Second minimum and Second maximum elements
of an array of type T and returns a pair containing the minimum and maximum value. */


import java.util.*;

public class SecondMinMax<T extends Comparable<T>> {

    public Pair<T, T> findSecondMinMax(T[] arr) {
        int n = arr.length;
        Arrays.sort(arr, Comparator.reverseOrder());

        T secondMin = null;
        T secondMax = null;

        for (int i = 1; i < n; i++) {
            if (!arr[i].equals(arr[0])) {
                secondMax = arr[i];
                break;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (!arr[i].equals(arr[n - 1])) {
                secondMin = arr[i];
                break;
            }
        }

        

        return new Pair<>(secondMin, secondMax);
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};
        SecondMinMax<Integer> secondMinMax = new SecondMinMax<>();
        Pair<Integer, Integer> result = secondMinMax.findSecondMinMax(arr);
        System.out.println("Second minimum: " + result.getFirst());
        System.out.println("Second maximum: " + result.getSecond());
    }
}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}

/*Second minimum: 2
Second maximum: 6 */