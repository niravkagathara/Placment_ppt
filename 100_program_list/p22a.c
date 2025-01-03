//     1  
//    b c  
//   2 3 4  
//  c d e f  

#include <stdio.h>

int main() {
    int n = 4; // Number of rows
    int number = 1; // Starting number
    char letter = 'b'; // Starting letter

    for (int i = 1; i <= n; i++) {
        // Print spaces for centering
        for (int j = 1; j <= n - i; j++) {
            printf(" ");
        }

        // Print the pattern for the current row
        for (int j = 1; j <= i; j++) {
            if (i % 2 == 1) {
                // Odd rows: print numbers
                printf("%d ", number);
                number++;
            } else {
                // Even rows: print letters
                printf("%c ", letter);
                letter++;
            }
        }

        printf("\n");
    }

    return 0;
}
