import java.util.HashMap;

public class p71 {
    
    public int findTargetSumWays(int[] nums, int target) {
        // A map to store the number of ways to reach a particular sum
        HashMap<String, Integer> memo = new HashMap<>();
        
        // Start the recursive function with index 0 and sum 0
        return findWays(nums, 0, 0, target, memo);
    }
    
    // Helper recursive function with memoization
    private int findWays(int[] nums, int index, int currentSum, int target, HashMap<String, Integer> memo) {
        // If we've processed all elements, check if current sum equals the target
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }
        
        // Memoization key
        String key = index + "," + currentSum;
        
        // Check if result is already computed
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // Recursively calculate the number of ways to achieve the target sum
        int add = findWays(nums, index + 1, currentSum + nums[index], target, memo);
        int subtract = findWays(nums, index + 1, currentSum - nums[index], target, memo);
        
        // Store the result in the memo and return the sum of both cases
        int result = add + subtract;
        memo.put(key, result);
        
        return result;
    }
    
    public static void main(String[] args) {
        p71 solution = new p71();
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        
        int result = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target: " + result);
    }
}
