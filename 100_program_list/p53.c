// Write a program to take 2 numbers from user and find out the distance between them.
// (How to compute distance: If number is 10 and 18 then 10 in binary 1010 and 18 in binary
// is 10010 and distance is 2 means total number of bits that needs to be changed when 10 is
// converted into 18 or 18 is converted into 10, do not convert the number into binary)
#include <stdio.h>

int countSetBits(int n) {
    int count = 0;
    while (n) {
        count += n & 1;  // Increment count if the least significant bit is 1
        n >>= 1;         // Right shift n to check the next bit
    }
    return count;
}

int main() {
    int num1, num2;

    // Taking two numbers as input from the user
    printf("Enter the first number: ");
    scanf("%d", &num1);
    
    printf("Enter the second number: ");
    scanf("%d", &num2);

    // XOR of num1 and num2
    int xorResult = num1 ^ num2;

    // Calculate the number of bits that need to be changed
    int distance = countSetBits(xorResult);

    // Output the result
    printf("The distance between %d and %d is: %d\n", num1, num2, distance);

    return 0;
}
