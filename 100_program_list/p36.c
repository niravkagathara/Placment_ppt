// WAP to sort an Array using Merge sort
#include <stdio.h>
#include <stdlib.h>

// Function to merge two halves into a sorted array
void merge(int* arr, int left, int mid, int right) {
    int n1 = mid - left + 1;  // Size of left subarray
    int n2 = right - mid;     // Size of right subarray

    // Create temporary arrays for left and right subarrays
    int* leftArr = (int*)malloc(n1 * sizeof(int));
    int* rightArr = (int*)malloc(n2 * sizeof(int));

    // Copy data into temporary arrays
    for (int i = 0; i < n1; i++)
        leftArr[i] = arr[left + i];
    for (int i = 0; i < n2; i++)
        rightArr[i] = arr[mid + 1 + i];

    // Merge the temporary arrays back into the original array
    int i = 0, j = 0, k = left;
    while (i < n1 && j < n2) {
        if (leftArr[i] <= rightArr[j]) {
            arr[k] = leftArr[i];
            i++;
        } else {
            arr[k] = rightArr[j];
            j++;
        }
        k++;
    }

    // Copy any remaining elements of leftArr
    while (i < n1) {
        arr[k] = leftArr[i];
        i++;
        k++;
    }

    // Copy any remaining elements of rightArr
    while (j < n2) {
        arr[k] = rightArr[j];
        j++;
        k++;
    }

    // Free the temporary arrays
    free(leftArr);
    free(rightArr);
}

// Function to implement Merge Sort
void mergeSort(int* arr, int left, int right) {
    if (left < right) {
        // Find the middle point
        int mid = left + (right - left) / 2;

        // Sort the first half
        mergeSort(arr, left, mid);

        // Sort the second half
        mergeSort(arr, mid + 1, right);

        // Merge the sorted halves
        merge(arr, left, mid, right);
    }
}

int main() {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int arrSize = sizeof(arr) / sizeof(arr[0]);

    printf("Unsorted array: \n");
    for (int i = 0; i < arrSize; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    // Call mergeSort
    mergeSort(arr, 0, arrSize - 1);

    printf("\nSorted array: \n");
    for (int i = 0; i < arrSize; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");

    return 0;
}
