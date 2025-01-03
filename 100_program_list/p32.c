// WAP to sort an Array using Quick sort. 
#include <stdio.h>

// Function to perform the partitioning step of Quick Sort
int partition(int arr[], int low, int high) {
    int pivot = arr[high];  // Choose the last element as the pivot
    int i = low - 1;  // Index of smaller element

    // Traverse through the array and rearrange elements
    for (int j = low; j <= high - 1; j++) {
        if (arr[j] < pivot) {
            i++;  // Increment the smaller element index
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Swap arr[i + 1] and arr[high] (pivot element)
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return (i + 1);  // Return the pivot index
}

// Function to implement Quick Sort
void quickSort(int arr[], int low, int high) {
    if (low < high) {
        // Find the pivot index after partitioning
        int pi = partition(arr, low, high);

        // Recursively sort the left and right subarrays
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}

// Function to print the array
void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int n;

    // Read the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];  // Array of size n

    // Read elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Call Quick Sort to sort the array
    quickSort(arr, 0, n - 1);

    // Print the sorted array
    printf("Sorted Array: ");
    printArray(arr, n);

    return 0;
}
