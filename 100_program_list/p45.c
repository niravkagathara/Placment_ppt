// WAP to convert a hexa-decimal to Octal. 
#include <stdio.h>
#include <string.h>
#include <math.h>

// Function to convert hexadecimal to decimal
int hexToDecimal(char hex[]) {
    int decimal = 0;
    int length = strlen(hex);
    int base = 1;  // 16^0

    // Traverse the hexadecimal string from right to left
    for (int i = length - 1; i >= 0; i--) {
        // Convert hex character to decimal
        if (hex[i] >= '0' && hex[i] <= '9') {
            decimal += (hex[i] - '0') * base;
        } else if (hex[i] >= 'A' && hex[i] <= 'F') {
            decimal += (hex[i] - 'A' + 10) * base;
        } else if (hex[i] >= 'a' && hex[i] <= 'f') {
            decimal += (hex[i] - 'a' + 10) * base;
        }
        base *= 16;  // Increase the power of 16
    }
    return decimal;
}

// Function to convert decimal to octal
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

int main() {
    char hex[100];
    printf("Enter a hexadecimal number: ");
    scanf("%s", hex);

    // Convert hexadecimal to decimal
    int decimal = hexToDecimal(hex);

    // Convert decimal to octal
    printf("The octal equivalent is: ");
    decimalToOctal(decimal);
    printf("\n");

    return 0;
}
