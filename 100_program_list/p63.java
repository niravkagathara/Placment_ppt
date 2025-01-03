// Given an array nums of distinct integers, return all the possible permutations. You can
// return the answer in any order.
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
import java.util.ArrayList;
import java.util.List;

public class p63 {

    // Function to generate all permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    // Helper function to perform backtracking
    private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        // If the temporary list has all elements, add it to result
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Loop through the array and swap elements to generate permutations
        for (int i = 0; i < nums.length; i++) {
            // Skip the element if it is already in the temporary list
            if (tempList.contains(nums[i])) continue;
            tempList.add(nums[i]); // Add the element to the list
            backtrack(nums, tempList, result); // Recursively build the rest of the permutation
            tempList.remove(tempList.size() - 1); // Backtrack and remove the last element
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute(nums);

        // Print the result
        System.out.println(result);
    }
}
