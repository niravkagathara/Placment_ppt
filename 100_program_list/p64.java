// You are climbing a staircase. It takes n steps to reach the top. Each time you can either
// climb 1 or 2 steps. In how many distinct ways can you climb to the top?
public class p64 {
    public static int climbStairs(int n) {
        // Base cases
        if (n == 0) return 1;
        if (n == 1) return 1;
        
        // Variables to store the number of ways to reach the previous two steps
        int prev1 = 1;  // ways to reach step 1
        int prev2 = 1;  // ways to reach step 0
        int current = 0;

        // Iterate from step 2 to step n and calculate the number of ways to reach each step
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;  // Current step is the sum of the previous two
            prev2 = prev1;            // Move prev1 to prev2
            prev1 = current;          // Move current to prev1
        }
        
        return current;  // The number of ways to reach step n
    }

    public static void main(String[] args) {
        int n = 5;  // Example input
        System.out.println("Number of ways to climb " + n + " steps: " + climbStairs(n));
    }
}
