// Find a next lexicographical order string from a given string, if input is abc output is acb (2
// condition must be followed 1st the string must be greater than the inputted string and the
// outputted string must be the smallest string from all possible string. Suppose there another
// string possible from this is acb, bac, bca, etc., but smallest is acb )
import java.util.*;

public class p62 {

    // Function to find the next lexicographical string
    public static String nextLexicographicalString(String s) {
        // Convert the string to a character array for easier manipulation
        char[] chars = s.toCharArray();
        int n = chars.length;

        // Step 1: Find the pivot (the first character that is smaller than its next character from right to left)
        int i = n - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        // If no such pivot is found, the string is already the largest permutation
        if (i == -1) {
            return "No next lexicographical string";
        }

        // Step 2: Find the smallest character in the suffix that is greater than the pivot
        int j = n - 1;
        while (chars[j] <= chars[i]) {
            j--;
        }

        // Step 3: Swap the pivot with the rightmost character that is larger than the pivot
        swap(chars, i, j);

        // Step 4: Reverse the suffix starting from i + 1 to the end of the string
        reverse(chars, i + 1, n - 1);

        // Return the new string
        return new String(chars);
    }

    // Helper method to swap two characters in the character array
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    // Helper method to reverse the part of the character array
    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String input = "abc";
        String nextString = nextLexicographicalString(input);
        System.out.println("Next lexicographical string: " + nextString);  // Output: acb
    }
}
