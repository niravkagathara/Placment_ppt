// WAP to sort an Array using shell sort.
#include <stdio.h>

void shellSort(int arr[], int n) {
    // Start with a large gap, and reduce the gap each time
    for (int gap = n / 2; gap > 0; gap /= 2) {
        // Perform a gapped insertion sort for this gap size
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;

            // Shift earlier gap-sorted elements to make space for the swapped element
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }

            arr[j] = temp;
        }
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
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

    // Sorting the array using Shell Sort
    shellSort(arr, n);

    // Print the sorted array
    printf("Sorted Array: ");
    printArray(arr, n);

    return 0;
}
