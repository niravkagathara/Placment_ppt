public class p95 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negative numbers and zeros with a number greater than n
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1; // A value that is out of the range
            }
        }

        // Step 2: Use the index as a hash to mark the presence of numbers
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); // Mark as negative
            }
        }

        // Step 3: Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1; // The first missing positive number
            }
        }

        return n + 1; // If all numbers are present
    }

    public static void main(String[] args) {
        p95 solution = new p95();
        int[] nums1 = {1, 2, 0};
        System.out.println(solution.firstMissingPositive(nums1)); // Output: 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(solution.firstMissingPositive(nums2)); // Output: 2
    }
}
