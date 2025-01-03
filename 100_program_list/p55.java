// You are given several boxes with different colors represented by different positive numbers.
// You may experience several rounds to remove boxes until there is no box left. Each time you
// can choose some continuous boxes with the same color (i.e., composed of k boxes, k >= 1),
// remove them and get k * k points.
// Return the maximum points you can get.
// Input: boxes = [1,3,2,2,2,3,4,3,1]
// Output: 23
// Explanation:
// [1, 3, 2, 2, 2, 3, 4, 3, 1]
// ----> [1, 3, 3, 4, 3, 1] (3*3=9 points)
// ----> [1, 3, 3, 3, 1] (1*1=1 points)
// ----> [1, 1] (3*3=9 points)
// ----> [] (2*2=4 points)
public class p55 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        // DP array to store the results
        int[][][] dp = new int[n][n][n];
        
        // Call the recursive function to fill dp table
        return dfs(boxes, 0, n - 1, 0, dp);
    }

    // Helper function: use 3D dp to store intermediate results
    private int dfs(int[] boxes, int start, int end, int extra, int[][][] dp) {
        // If the range is invalid, return 0
        if (start > end) return 0;
        
        // If the result for this state is already calculated, return it
        if (dp[start][end][extra] != 0) return dp[start][end][extra];
        
        // Calculate the result if we only take boxes[start] group together
        int res = (extra + 1) * (extra + 1) + dfs(boxes, start + 1, end, 0, dp);
        
        // Try to combine boxes[start] with other same boxes from start+1 to end
        for (int i = start + 1; i <= end; i++) {
            if (boxes[i] == boxes[start]) {
                res = Math.max(res, dfs(boxes, start + 1, i - 1, extra + 1, dp) + dfs(boxes, i + 1, end, 0, dp));
            }
        }
        
        // Store the result for dp[start][end][extra]
        dp[start][end][extra] = res;
        return res;
    }

    public static void main(String[] args) {
        p55 solution = new p55();
        int[] boxes = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(solution.removeBoxes(boxes));  // Output: 23
    }
}
