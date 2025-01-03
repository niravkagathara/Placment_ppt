import java.util.HashMap;

public class p72{
    
    // Function to calculate sum of digits of a number
    private static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        // Iterate through the nums array
        for (int num : nums) {
            int sumDigits = sumOfDigits(num);
            
            // If sum of digits already exists in map, calculate the potential sum
            if (map.containsKey(sumDigits)) {
                // Compare the current sum with the previously stored max number for this sum
                maxSum = Math.max(maxSum, num + map.get(sumDigits));
            }
            
            // Update the map to store the maximum number for this sum of digits
            map.put(sumDigits, Math.max(map.getOrDefault(sumDigits, 0), num));
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        p72 solution = new p72();
        int[] nums = {18, 43, 36, 13, 7};
        
        int result = solution.maximumSum(nums);
        System.out.println("Maximum sum of nums[i] + nums[j]: " + result);
    }
}
