// WAP to sort an Array using Counting sort.
#include <stdio.h>

void countingSort(int arr[], int n) {
    int max = arr[0];
    
    // Find the maximum element in the array to define the range
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }

    // Create a count array to store the frequency of each element
    int count[max + 1]; 
    for (int i = 0; i <= max; i++) {
        count[i] = 0; // Initialize the count array
    }

    // Store the frequency of each element in the count array
    for (int i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    // Modify the count array by adding the previous counts (cumulative sum)
    for (int i = 1; i <= max; i++) {
        count[i] += count[i - 1];
    }

    // Create the output array to store the sorted elements
    int output[n];
    
    // Build the output array using the count array
    for (int i = n - 1; i >= 0; i--) {
        output[count[arr[i]] - 1] = arr[i];
        count[arr[i]]--; // Decrement the count of the current element
    }

    // Copy the sorted elements back into the original array
    for (int i = 0; i < n; i++) {
        arr[i] = output[i];
    }

    // Print the sorted array
    printf("Sorted Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int n;

    // Reading the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];  // Array of size n

    // Reading elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Sorting the array using counting sort
    countingSort(arr, n);

    return 0;
}
