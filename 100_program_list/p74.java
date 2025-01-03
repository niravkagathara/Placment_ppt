public class p74 {

    public int maxPileTop(int[] nums, int k) {
        int n = nums.length;

        // If there are no elements in the pile and k > 0, it's impossible to make any move.
        if (n == 0) {
            return -1;
        }

        // Case when k >= n: we can remove all elements and pick the max one to add back.
        if (k >= n) {
            return getMax(nums);
        }

        // If k is less than n, we can only remove up to k elements.
        // We need to find the maximum value among the first k + 1 elements.
        return getMax(nums, k + 1);
    }

    // Helper function to get the maximum value in an array up to a given index.
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Overloaded helper function to get the maximum value within the first 'limit' elements.
    private int getMax(int[] nums, int limit) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < limit; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        p74 solution = new p74();
        int[] nums = {3, 1, 4, 1, 5};
        int k = 3;
        
        int result = solution.maxPileTop(nums, k);
        System.out.println("Maximum topmost element after " + k + " moves: " + result);  // Output will depend on k
    }
}
