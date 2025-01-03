// WAP to implement a sliding window problem. You are given an array of integers nums,
// there is a sliding window of size k which is moving from the very left of the array to the
// very right. You can only see the k numbers in the window. Each time the sliding window
// moves right by one position.
// Input: nums = [1,3, -1, -3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position Max
// --------------- -----
// [1 3 -1] -3 5 3 6 7 3
// 1 [3 -1 -3] 5 3 6 7 3
// 1 3 [-1 -3 5] 3 6 7 5
// 1 3 -1 [-3 5 3] 6 7 5
// 1 3 -1 -3 [5 3 6] 7 6
// 1 3 -1 -3 5 [3 6 7] 7
#include <stdio.h>
#include <stdlib.h>

// Function to find the maximum in each sliding window
void slidingWindowMax(int nums[], int n, int k) {
    if (n == 0 || k == 0) return;
    
    // Create a deque to store indices of potential maximums
    int *deque = (int *)malloc(n * sizeof(int)); // stores indices
    int front = 0, rear = -1;

    for (int i = 0; i < n; i++) {
        // Remove indices of elements out of the current window
        if (front <= rear && deque[front] <= i - k) {
            front++;
        }

        // Remove all elements smaller than the current element from deque
        while (front <= rear && nums[deque[rear]] <= nums[i]) {
            rear--;
        }

        // Add current element index to deque
        deque[++rear] = i;

        // If we have processed at least k elements, print the maximum of the window
        if (i >= k - 1) {
            printf("%d ", nums[deque[front]]);
        }
    }

    printf("\n");
    free(deque);
}

int main() {
    int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
    int n = sizeof(nums) / sizeof(nums[0]);
    int k = 3;

    printf("Sliding window maximums: ");
    slidingWindowMax(nums, n, k);

    return 0;
}
