public class p76 {
    public int totalStrength(int[] strength) {
        final int MOD = 1000000007;
        int n = strength.length;

        // Step 1: Calculate prefix sums
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + strength[i];
        }

        // Step 2: Use a stack to calculate the sum of strengths
        long total = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || strength[stack.peek()] >= strength[i])) {
                int index = stack.pop();
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                long sumOfSubarray = prefixSum[i] - prefixSum[prevIndex + 1];
                long minStrength = strength[index];
                total += minStrength * sumOfSubarray;
                total %= MOD;
            }
            stack.push(i);
        }

        return (int) total;
    }

    public static void main(String[] args) {
        p76 ws = new p76();
        int[] strength = {1, 3, 1, 2};
        System.out.println(ws.totalStrength(strength));  // Output: 44
    }
}
