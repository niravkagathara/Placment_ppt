// Given an array nums with n integers, your task is to check if it could become non-decreasing
// by modifying at most one
// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array
#include <stdio.h>
#include <stdbool.h>

bool checkPossibility(int nums[], int numsSize) {
    int count = 0;
    
    // Traverse the array
    for (int i = 1; i < numsSize; i++) {
        // If we find a violation (nums[i-1] > nums[i])
        if (nums[i-1] > nums[i]) {
            // If we have already fixed one violation, return false
            if (count > 0) {
                return false;
            }
            count++;
            
            // Try to modify nums[i-1] or nums[i]
            // If we are at the beginning or the modification is valid, do it
            if (i == 1 || nums[i-2] <= nums[i]) {
                // Modify nums[i-1]
                nums[i-1] = nums[i];
            } else {
                // Modify nums[i]
                nums[i] = nums[i-1];
            }
        }
    }
    
    // If we find one or fewer violations, the array can be made non-decreasing
    return true;
}

int main() {
    int nums[] = {4, 2, 3};
    int numsSize = sizeof(nums) / sizeof(nums[0]);

    if (checkPossibility(nums, numsSize)) {
        printf("Output: true\n");
    } else {
        printf("Output: false\n");
    }

    return 0;
}
