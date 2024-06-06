import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class fractionalKnapsack {
    static double fractionalKnapsack(int W, Item[] arr) {
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        int curWeight = 0;
        double finalValue = 0.0;

        for (Item item : arr) {
            if (curWeight + item.weight <= W) {
                curWeight += item.weight;
                finalValue += item.value;
            } else {
                int remain = W - curWeight;
                finalValue += ((double) item.value / item.weight) * remain;
                break;
            }
        }

        return finalValue;
    }

    public static void main(String[] args) {
        Item[] arr = {new Item(100, 20), new Item(60, 10), new Item(120, 30)};
        double ans = fractionalKnapsack(50, arr);
        System.out.println("The maximum value is " + ans);
    }
}

