// Given two integer arrays nums1 and nums2, return an array of their intersection. Each
// element in the result must appear as many times as it shows in both arrays and you may
// return the result in sorted order.
#include <stdio.h>
#include <stdlib.h>

// Function to compare two elements (for sorting)
int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

// Function to find the intersection of two arrays
int* intersect(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    // Sort both arrays to help with intersection and comparison
    qsort(nums1, nums1Size, sizeof(int), compare);
    qsort(nums2, nums2Size, sizeof(int), compare);

    // Allocate memory for the result array
    int* result = (int*)malloc(sizeof(int) * (nums1Size < nums2Size ? nums1Size : nums2Size));
    *returnSize = 0;

    // Pointers for both arrays
    int i = 0, j = 0;

    // Iterate through both arrays to find the common elements
    while (i < nums1Size && j < nums2Size) {
        if (nums1[i] < nums2[j]) {
            i++;
        } else if (nums1[i] > nums2[j]) {
            j++;
        } else {
            result[*returnSize] = nums1[i];
            (*returnSize)++;
            i++;
            j++;
        }
    }

    // Return the result array
    return result;
}

int main() {
    // Example arrays
    int nums1[] = {4, 9, 5};
    int nums2[] = {9, 4, 9, 8, 4};
    int nums1Size = sizeof(nums1) / sizeof(nums1[0]);
    int nums2Size = sizeof(nums2) / sizeof(nums2[0]);

    // Variable to hold the size of the result array
    int returnSize;

    // Find the intersection
    int* result = intersect(nums1, nums1Size, nums2, nums2Size, &returnSize);

    // Print the result
    printf("Intersection: ");
    for (int i = 0; i < returnSize; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    // Free the allocated memory
    free(result);

    return 0;
}
