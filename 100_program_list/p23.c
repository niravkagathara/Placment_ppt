// WAP to enter an element at specific position into array. (Do not take a new array)
#include <stdio.h>

void insertAtPosition(int arr[], int n, int element, int pos) {
    // If the position is valid
    if (pos < 1 || pos > n + 1) {
        printf("Invalid position.\n");
        return;
    }

    // Shifting elements to the right to make space for the new element
    for (int i = n - 1; i >= pos - 1; i--) {
        arr[i + 1] = arr[i];
    }

    // Inserting the element at the specified position
    arr[pos - 1] = element;

    printf("Array after insertion: ");
    for (int i = 0; i <= n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

int main() {
    int n, pos, element;

    // Reading the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n + 1];  // Array of size n + 1 to accommodate the new element

    // Reading elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Reading the position and element to be inserted
    printf("Enter the position where you want to insert the element: ");
    scanf("%d", &pos);

    printf("Enter the element to insert: ");
    scanf("%d", &element);

    // Inserting the element at the specified position
    insertAtPosition(arr, n, element, pos);

    return 0;
}
