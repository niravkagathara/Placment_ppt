// WAP to check weather number is present in array or not (using recursion only) and the
// function’s syntax is given below
// Int isInArray(int a[],int m);
// Where int a[] is Array of integer and m is element to be searched. 
#include <stdio.h>

// Recursive function to check if element is present in the array
int isInArray(int a[], int n, int m) {
    // Base case: if we have checked all elements
    if (n < 0) {
        return 0; // Element not found
    }
    
    // If the current element matches the element to search for
    if (a[n] == m) {
        return 1; // Element found
    }
    
    // Recursive case: check the next element
    return isInArray(a, n - 1, m);
}

int main() {
    int n, m;

    // Reading the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int a[n];  // Array of size n

    // Reading elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    // Reading the element to search
    printf("Enter the element to search: ");
    scanf("%d", &m);

    // Call the recursive function to check if the element is in the array
    if (isInArray(a, n - 1, m)) {
        printf("Element %d is present in the array.\n", m);
    } else {
        printf("Element %d is not present in the array.\n", m);
    }

    return 0;
}
