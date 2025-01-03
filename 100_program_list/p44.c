// WAP to convert an Octal into hexa-decimal.
#include <stdio.h>
#include <math.h>

// Function to convert octal to decimal
int octalToDecimal(int octal) {
    int decimal = 0, base = 1;
    while (octal > 0) {
        int last_digit = octal % 10;
        decimal += last_digit * base;
        base *= 8;
        octal /= 10;
    }
    return decimal;
}

// Function to convert decimal to hexadecimal
void decimalToHexadecimal(int decimal) {
    if (decimal == 0) {
        printf("0");
        return;
    }

    char hex[100];
    int i = 0;

    while (decimal != 0) {
        int remainder = decimal % 16;
        if (remainder < 10)
            hex[i] = 48 + remainder;  // Convert to char '0' to '9'
        else
            hex[i] = 55 + remainder;  // Convert to char 'A' to 'F'
        i++;
        decimal /= 16;
    }

    // Print the hexadecimal in reverse order
    for (int j = i - 1; j >= 0; j--) {
        printf("%c", hex[j]);
    }
}

int main() {
    int octal;
    printf("Enter an octal number: ");
    scanf("%d", &octal);

    // Convert octal to decimal
    int decimal = octalToDecimal(octal);

    // Convert decimal to hexadecimal
    printf("The hexadecimal equivalent is: ");
    decimalToHexadecimal(decimal);
    printf("\n");

    return 0;
}
