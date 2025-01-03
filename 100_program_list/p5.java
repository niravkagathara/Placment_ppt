// WAP to find a summation of a digit of a given number. (Iterative and recursive)
public class p5 {
    // Iterative method
    public static int sumOfDigitsIterative(int n) {
        int total = 0;
        while (n > 0) {
            total += n % 10;
            n /= 10;
        }
        return total;
    }

    // Recursive method
    public static int sumOfDigitsRecursive(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumOfDigitsRecursive(n / 10);
        }
    }

    // Example
    public static void main(String[] args) {
        int number = 12345;
        System.out.println("Iterative Sum: " + sumOfDigitsIterative(number));
        System.out.println("Recursive Sum: " + sumOfDigitsRecursive(number));
    }
}