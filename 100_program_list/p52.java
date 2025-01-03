// Given a non-negative integer x, compute and return the square root of x.
// Since the return type is an integer, the decimal digits are truncated, and only the integer part
// of the result is returned.
// Note: You are not allowed to use any built-in exponent function or operator, such as pow(x,
// 0.5) or x ** 0.5.
public class p52 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        
        int left = 1, right = x;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            // Check if mid * mid equals x
            if (mid * mid == x) {
                return mid;
            }
            
            // If mid * mid is less than x, the square root must be greater
            if (mid * mid < x) {
                left = mid + 1;
            }
            // If mid * mid is greater than x, the square root must be smaller
            else {
                right = mid - 1;
            }
        }
        
        // When the loop ends, right will be the integer part of the square root
        return right;
    }

    public static void main(String[] args) {
        p52 solution = new p52();
        
        int x = 8;
        System.out.println("The square root of " + x + " is: " + solution.mySqrt(x)); // Output: 2
    }
}
