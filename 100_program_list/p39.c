// Given an array, rotate the array to the right by k steps, where k is non-negative.
// Example 1:
// Input: nums = [1,2,3,4,5,6,7], k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 step to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
#include <stdio.h>

void reverse(int nums[], int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}

void rotate(int nums[], int numsSize, int k) {
    k = k % numsSize;  // Normalize k to avoid unnecessary rotations
    
    // Step 1: Reverse the entire array
    reverse(nums, 0, numsSize - 1);
    
    // Step 2: Reverse the first k elements
    reverse(nums, 0, k - 1);
    
    // Step 3: Reverse the remaining n - k elements
    reverse(nums, k, numsSize - 1);
}

void printArray(int nums[], int numsSize) {
    for (int i = 0; i < numsSize; i++) {
        printf("%d ", nums[i]);
    }
    printf("\n");
}

int main() {
    int nums[] = {1, 2, 3, 4, 5, 6, 7};
    int numsSize = sizeof(nums) / sizeof(nums[0]);
    int k = 3;
    
    printf("Original Array: ");
    printArray(nums, numsSize);
    
    rotate(nums, numsSize, k);
    
    printf("Array after rotating by %d steps: ", k);
    printArray(nums, numsSize);
    
    return 0;
}
