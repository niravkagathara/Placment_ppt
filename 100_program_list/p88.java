import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    // Get the value-to-weight ratio
    double getValueToWeightRatio() {
        return (double) value / weight;
    }
}

public class p88 {

    // Function to solve 0/1 knapsack problem using Greedy approach
    public static int knapsackGreedy(int[] value, int[] weight, int n, int W) {
        // Create an array of items
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        // Sort items based on value-to-weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare(b.getValueToWeightRatio(), a.getValueToWeightRatio()));

        int totalValue = 0;
        int totalWeight = 0;

        // Start adding items to the knapsack
        for (int i = 0; i < n; i++) {
            if (totalWeight + items[i].weight <= W) {
                totalValue += items[i].value;
                totalWeight += items[i].weight;
            } else {
                break; // No more items can be added
            }
        }

        return totalValue;
    }

    // Main driver method
    public static void main(String[] args) {
        int[] value = {10, 5, 15, 7, 6, 18, 3};
        int[] weight = {2, 3, 5, 7, 1, 4, 1};
        int W = 15; // Knapsack capacity
        int n = value.length;

        System.out.println("Maximum value that can be obtained: " + knapsackGreedy(value, weight, n, W));
    }
}
