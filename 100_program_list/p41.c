// You are given an integer num. Rearrange the digits of num such that its value is minimized
// and it does not contain any leading zeros.
// Return the rearranged number with minimal value.
// Note that the sign of the number does not change after rearranging the digits.
// Input: num = 310
// Output: 103
// Explanation: The possible arrangements for the digits of 310 are 013, 031, 103, 130, 301,
// 310.
// The arrangement with the smallest value that does not contain any leading zeros is 103.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Helper function to compare two characters for sorting
int compare(const void *a, const void *b) {
    return (*(char*)a - *(char*)b);
}

int rearrange(int num) {
    char str[12]; // To hold the string representation of the number
    int isNegative = num < 0;
    
    // If the number is negative, convert to positive
    if (isNegative) {
        num = -num;
    }

    // Convert the number to string
    snprintf(str, sizeof(str), "%d", num);
    int len = strlen(str);
    
    // Sort the digits in ascending order
    qsort(str, len, sizeof(char), compare);

    // For a positive number, ensure no leading zero
    if (!isNegative) {
        // Find the first non-zero digit and swap it to the front
        if (str[0] == '0') {
            for (int i = 1; i < len; i++) {
                if (str[i] != '0') {
                    // Swap the first non-zero digit to the front
                    char temp = str[i];
                    str[i] = str[0];
                    str[0] = temp;
                    break;
                }
            }
        }
    }

    // Convert back to integer
    return isNegative ? -atoi(str) : atoi(str);
}

int main() {
    int num = 310;
    printf("Rearranged number: %d\n", rearrange(num));

    num = -310;
    printf("Rearranged number: %d\n", rearrange(num));

    num = 0;
    printf("Rearranged number: %d\n", rearrange(num));

    return 0;
}
