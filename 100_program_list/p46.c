// WAP to Convert a Decimal to Octal and Vice versa.
#include <stdio.h>
#include <string.h>
#include <math.h>

// Function to convert Decimal to Octal
void decimalToOctal(int decimal) {
    if (decimal == 0) {
        printf("0");
        return;
    }

    int octal[100];
    int i = 0;

    // Convert decimal to octal
    while (decimal != 0) {
        octal[i] = decimal % 8;
        decimal /= 8;
        i++;
    }

    // Print the octal digits in reverse order
    for (int j = i - 1; j >= 0; j--) {
        printf("%d", octal[j]);
    }
}

// Function to convert Octal to Decimal
int octalToDecimal(int octal) {
    int decimal = 0;
    int base = 1;

    // Convert octal to decimal
    while (octal > 0) {
        int last_digit = octal % 10;
        decimal += last_digit * base;
        base *= 8;
        octal /= 10;
    }
    return decimal;
}

int main() {
    int choice, decimal, octal;

    printf("Select Conversion Type:\n");
    printf("1. Decimal to Octal\n");
    printf("2. Octal to Decimal\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            printf("Enter a Decimal number: ");
            scanf("%d", &decimal);
            printf("The Octal equivalent is: ");
            decimalToOctal(decimal);
            printf("\n");
            break;

        case 2:
            printf("Enter an Octal number: ");
            scanf("%d", &octal);
            printf("The Decimal equivalent is: %d\n", octalToDecimal(octal));
            break;

        default:
            printf("Invalid choice\n");
    }

    return 0;
}
