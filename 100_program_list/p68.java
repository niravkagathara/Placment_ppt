// Given an integer n, return the least number of perfect square numbers that sum to n.
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.
// Input: n = 13
// Output: 2
// Explanation: 13 = 4 + 9.
public class p68 {
    public static int numSquares(int n) {
        // Initialize dp array where dp[i] will store the least number of perfect squares that sum to i
        int[] dp = new int[n + 1];
        
        // Fill dp array with maximum values
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Base case: 0 requires 0 perfect squares
        dp[0] = 0;

        // For each number from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check for all perfect squares less than or equal to i
            for (int square = 1; square * square <= i; square++) {
                dp[i] = Math.min(dp[i], dp[i - square * square] + 1);
            }
        }

        // The result is the value of dp[n]
        return dp[n];
    }

    public static void main(String[] args) {
        // Test cases
        int n1 = 12;
        int n2 = 13;
        System.out.println("Minimum perfect squares for " + n1 + ": " + numSquares(n1)); // Output: 3
        System.out.println("Minimum perfect squares for " + n2 + ": " + numSquares(n2)); // Output: 2
    }
}
