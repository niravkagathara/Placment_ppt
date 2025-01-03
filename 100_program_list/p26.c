// WAP to convert a Binary to Decimal
#include <stdio.h>
#include <math.h>

// Function to convert binary to decimal
int binaryToDecimal(int binary) {
    int decimal = 0, i = 0, remainder;
    
    while (binary != 0) {
        remainder = binary % 10;  // Get the last bit
        decimal += remainder * pow(2, i);  // Add the value of the bit
        binary /= 10;  // Remove the last bit
        i++;  // Move to the next bit position
    }
    
    return decimal;
}

int main() {
    int binary, decimal;

    // Read the binary number from the user
    printf("Enter a binary number: ");
    scanf("%d", &binary);

    // Convert binary to decimal
    decimal = binaryToDecimal(binary);

    // Print the result
    printf("Decimal equivalent of binary %d is: %d\n", binary, decimal);

    return 0;
}
// Binary to Decimal Conversion:
