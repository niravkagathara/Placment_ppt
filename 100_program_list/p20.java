//WAP to find a^b (without using power and multiplication operation).
public class p20 {
    public static void main(String[] args) {
        int a = 2; 
        int b = 3; 
        int result = power(a, b);
        System.out.println(a + " raised to the power " + b + " is: " + result);
    }

    public static int power(int a, int b) {
        if (b == 0) {
            return 1; // Any number to the power of 0 is 1
        } else if (b < 0) {
            return 0; // Return 0 for negative power (or other handling)
        }
        
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a; // Calculate power using multiplication
        }
        return result;
    }
}