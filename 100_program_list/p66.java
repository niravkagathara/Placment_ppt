// Given an integer array, return the k-th smallest distance among all the pairs. The distance
// of a pair (A, B) is defined as the absolute difference between A and B.
// E.g.
// nums = [1,3,1,2]
// k = 3
// Output: 1
// Explanation:
// Here are all the pairs:Given an integer array, return the k-th smallest distance among all the pairs. The distance
// of a pair (A, B) is defined as the absolute difference between A and B.
// E.g.
// nums = [1,3,1,2]
// k = 3
// Output: 1
// Explanation:
// Here are all the pairs:(1,3) -> 2
// (1,1) -> 0
// (1,2) -> 1
// (3,1) -> 2
// (3,2) -> 1
// (1,2) -> 1
// Then the 3rd smallest distance pair is (1,3) and its distance is 2
import java.util.Arrays;

public class p66 {
    
    // Function to count how many pairs have a distance <= mid
    public static int countPairs(int[] nums, int mid) {
        int count = 0;
        int n = nums.length;
        int left = 0;
        
        // Two-pointer approach to count the pairs
        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left; // All pairs from left to right have distance <= mid
        }
        return count;
    }
    
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        
        int left = 0, right = nums[nums.length - 1] - nums[0]; // Binary search range
        
        while (left < right) {
            int mid = left + (right - left) / 2; // Mid distance
            
            if (countPairs(nums, mid) >= k) {
                right = mid; // If there are enough pairs with this distance, try smaller
            } else {
                left = mid + 1; // Otherwise, try larger distances
            }
        }
        
        return left; // The smallest distance with at least k pairs
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 2};
        int k = 3;
        
        int result = smallestDistancePair(nums, k);
        System.out.println("The " + k + "-th smallest distance is: " + result);
    }
}
