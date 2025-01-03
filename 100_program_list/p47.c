// WAP to Convert a Decimal to Hexa-decimal and vice versa. 
#include <stdio.h>
#include <string.h>
#include <math.h>

// Function to convert Decimal to Hexadecimal
void decimalToHexadecimal(int decimal) {
    if (decimal == 0) {
        printf("0");
        return;
    }

    char hex[100];
    int i = 0;

    // Hexadecimal digits are stored in the array
    while (decimal != 0) {
        int remainder = decimal % 16;
        
        // If remainder is less than 10, store it as a number
        if (remainder < 10) {
            hex[i] = remainder + '0';
        } else { // If remainder is 10 or more, convert to 'A' to 'F'
            hex[i] = remainder - 10 + 'A';
        }
        
        decimal /= 16;
        i++;
    }

    // Print the hexadecimal digits in reverse order
    for (int j = i - 1; j >= 0; j--) {
        printf("%c", hex[j]);
    }
}

// Function to convert Hexadecimal to Decimal
int hexadecimalToDecimal(char hex[]) {
    int decimal = 0;
    int length = strlen(hex);
    int base = 1; // 16^0

    // Traverse the hexadecimal string from right to left
    for (int i = length - 1; i >= 0; i--) {
        // If the digit is 0-9, convert it to an integer
        if (hex[i] >= '0' && hex[i] <= '9') {
            decimal += (hex[i] - '0') * base;
        } 
        // If the digit is A-F, convert it to the corresponding decimal value
        else if (hex[i] >= 'A' && hex[i] <= 'F') {
            decimal += (hex[i] - 'A' + 10) * base;
        }
        base *= 16; // Increase the power of 16
    }
    return decimal;
}

int main() {
    int choice, decimal;
    char hex[100];

    printf("Select Conversion Type:\n");
    printf("1. Decimal to Hexadecimal\n");
    printf("2. Hexadecimal to Decimal\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            printf("Enter a Decimal number: ");
            scanf("%d", &decimal);
            printf("The Hexadecimal equivalent is: ");
            decimalToHexadecimal(decimal);
            printf("\n");
            break;

        case 2:
            printf("Enter a Hexadecimal number: ");
            scanf("%s", hex);
            printf("The Decimal equivalent is: %d\n", hexadecimalToDecimal(hex));
            break;

        default:
            printf("Invalid choice\n");
    }

    return 0;
}
