// Given a positive integer n, return the number of the integers in the range [0, n] whose binary
// representations do not contain consecutive ones.
public class p70 {
    public static int findIntegers(int n) {
        // Convert the number to binary and count the number of bits
        String binary = Integer.toBinaryString(n);
        int len = binary.length();
        
        // DP array to store number of valid numbers for each length
        int[] dp = new int[len + 1];
        dp[0] = 1;  // Base case: 1 valid number for 0 bits (the empty number).
        dp[1] = 2;  // Base case: 2 valid numbers for 1 bit (0 and 1).
        
        // Fill the DP table for lengths from 2 to len
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        // Now, we need to go through the binary digits of `n` and count valid numbers
        int result = 0;
        int prevBit = 0;  // Tracks the previous bit (to ensure no consecutive ones).
        
        for (int i = 0; i < len; i++) {
            if (binary.charAt(i) == '1') {
                result += dp[len - i - 1];  // Add all valid numbers with the remaining bits.
                
                // If previous bit is also 1, we can't include any further numbers.
                if (prevBit == 1) {
                    return result;
                }
                
                prevBit = 1;  // Mark current bit as 1.
            } else {
                prevBit = 0;  // Mark current bit as 0.
            }
        }
        
        // Include the number `n` itself if it is valid (no consecutive ones).
        return result + 1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(findIntegers(n));  // Output: 5
    }
}
