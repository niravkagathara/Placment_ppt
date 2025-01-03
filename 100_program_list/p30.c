// WAP to convert a Decimal to Binary. 
#include <stdio.h>

void decimalToBinary(int n) {
    int binary[32];  // Array to store the binary digits
    int i = 0;

    // Special case for 0
    if (n == 0) {
        printf("Binary: 0\n");
        return;
    }

    // Convert the decimal number to binary
    while (n > 0) {
        binary[i] = n % 2;  // Store the remainder (either 0 or 1)
        n = n / 2;           // Divide the number by 2
        i++;
    }

    // Print the binary number in reverse order
    printf("Binary: ");
    for (int j = i - 1; j >= 0; j--) {
        printf("%d", binary[j]);
    }
    printf("\n");
}

int main() {
    int decimal;

    // Read the decimal number
    printf("Enter a decimal number: ");
    scanf("%d", &decimal);

    // Call the function to convert and display the binary equivalent
    decimalToBinary(decimal);

    return 0;
}
