// WAP to delete an element from array specified by user. if element is not found print a
// message “Element is not found” (do not take a new array).
#include <stdio.h>

void deleteElement(int arr[], int *n, int element) {
    int i, found = 0;

    // Search for the element to delete
    for (i = 0; i < *n; i++) {
        if (arr[i] == element) {
            found = 1;
            break;
        }
    }

    if (!found) {
        printf("Element is not found.\n");
        return;
    }

    // Shift elements to the left to fill the gap created by the deleted element
    for (int j = i; j < *n - 1; j++) {
        arr[j] = arr[j + 1];
    }

    // Reduce the size of the array
    (*n)--;

    // Print the array after deletion
    printf("Array after deletion: ");
    for (int i = 0; i < *n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int n, element;

    // Reading the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];  // Array of size n

    // Reading elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Reading the element to delete
    printf("Enter the element to delete: ");
    scanf("%d", &element);

    // Deleting the element from the array
    deleteElement(arr, &n, element);

    return 0;
}
