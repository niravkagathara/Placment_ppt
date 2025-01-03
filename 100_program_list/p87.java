public class p87 {

    // Function to solve the 0/1 Knapsack problem using dynamic programming
    public static int knapsack(int[] weight, int[] value, int n, int W) {
        // dp[i][w] will hold the maximum value that can be obtained
        // with the first i items and a knapsack capacity of w
        int[][] dp = new int[n + 1][W + 1];

        // Build the dp table in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case: no items or no capacity
                } else if (weight[i - 1] <= w) {
                    // If the item can be included in the knapsack
                    dp[i][w] = Math.max(dp[i - 1][w], // Exclude the item
                            dp[i - 1][w - weight[i - 1]] + value[i - 1]); // Include the item
                } else {
                    // If the item cannot be included in the knapsack
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // The result will be in dp[n][W]
        return dp[n][W];
    }

    // Driver function to test the knapsack function
    public static void main(String[] args) {
        // Example inputs: weights and values of the items
        int[] weight = {1, 3, 4, 5}; // Weights of the items
        int[] value = {1, 4, 5, 7};  // Values of the items
        int W = 7;  // Maximum capacity of the knapsack
        int n = weight.length;  // Number of items

        // Call the knapsack function and print the result
        System.out.println("Maximum value that can be obtained: " + knapsack(weight, value, n, W));
    }
}
