// WAP to find a quotient and reminder of 2 number (bigger number should be divided by
// lower number) and you are not allowed to use a division and quotient operator.
#include <stdio.h>

void findQuotientAndRemainder(int a, int b) {
    int quotient = 0;
    int remainder = a;

    // Ensure 'a' is the larger number and 'b' is the smaller one
    if (a < b) {
        // Swap a and b if a is smaller than b
        int temp = a;
        a = b;
        b = temp;
    }

    // Subtract the smaller number 'b' from 'a' until 'a' becomes smaller than 'b'
    while (remainder >= b) {
        remainder -= b;
        quotient++;
    }

    // Print the results
    printf("Quotient: %d\n", quotient);
    printf("Remainder: %d\n", remainder);
}

int main() {
    int a, b;

    // Read two numbers
    printf("Enter two numbers (larger number first): ");
    scanf("%d %d", &a, &b);

    // Call the function to find quotient and remainder
    findQuotientAndRemainder(a, b);

    return 0;
}
// Enter two numbers (larger number first): 17 4
// Quotient: 4
// Remainder: 1
