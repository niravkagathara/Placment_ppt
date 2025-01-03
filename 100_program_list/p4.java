// WAP to find a factorial of a given integer (iterative and recursive)
public class p4 {

    // Iterative approach
    public static int factorialIterative(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Recursive approach
    public static int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        System.out.println("Factorial of " + number + " (Iterative): " + factorialIterative(number));
        System.out.println("Factorial of " + number + " (Recursive): " + factorialRecursive(number));
    }
}