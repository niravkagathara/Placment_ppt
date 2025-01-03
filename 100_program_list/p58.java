// Write a program to check weather number is happy number is not, happy number are those
// number whose digit’s square summation eventually reaches to 1, if the sequence start
// repeating then it is not a happy number, to store this sequence, use a dynamic data structure.
// E.g., 49 is a happy number whose sequence is 49 97 130 10 1
// E.g., 50 is not a happy number whose sequence is 50 25 29 85 89 145 42 20 4 16 37 58 89
// it should stop when 89 is detected 2nd time and print 50 is not a happy number.
import java.util.HashSet;

public class p58 {
    
    // Helper function to calculate the sum of squares of digits
    public static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
    
    // Function to check if a number is a happy number
    public static boolean isHappyNumber(int num) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        
        while (num != 1 && !seenNumbers.contains(num)) {
            seenNumbers.add(num);  // Add the current number to the set
            num = sumOfSquares(num);  // Calculate the sum of squares of digits
        }
        
        // If the number reaches 1, it's a happy number, otherwise, it repeats and is not happy
        return num == 1;
    }
    
    public static void main(String[] args) {
        int num1 = 49;
        int num2 = 50;
        
        if (isHappyNumber(num1)) {
            System.out.println(num1 + " is a happy number.");
        } else {
            System.out.println(num1 + " is not a happy number.");
        }
        
        if (isHappyNumber(num2)) {
            System.out.println(num2 + " is a happy number.");
        } else {
            System.out.println(num2 + " is not a happy number.");
        }
    }
}
