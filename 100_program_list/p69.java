// Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9,
// 10, 11, ...]
// Input: n = 11
// Output: 0
// Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is
// part of the number 10.

// aa code ma error che
public class p69 {
    public static int findNthDigit(int n) {
        long length = 1; // Length of the numbers (1 for single digit, 2 for double digit, etc.)
        long count = 9;  // Count of numbers with 'length' digits
        long start = 1;  // Start of the range of numbers with 'length' digits

        // Find the length of the number that contains the n-th digit
        while (n > length * count) {
            n -= length * count;  // Reduce n by the number of digits in the current length
            length++;              // Move to the next length
            count *= 10;           // Increase the count of numbers with the new length
            start *= 10;           // Start of the new range
        }

        // Find the number containing the n-th digit
        long num = start + (n - 1) / length;  // Find the actual number
        int digitIndex = (int)((n - 1) % length);    // Find the position of the digit within the number

        // Convert number to string and return the digit at the required index
        return String.valueOf(num).charAt(digitIndex) - '0';
    }

    public static void main(String[] args) {
        // Test the function with an example
        int n = 11;
        System.out.println(findNthDigit(n));  // Output: 0
    }
}
