// Iterative method to find factors of a given number
public class p3 {
    public static void main(String[] args) {
        int number = 12; // Change this to any number you want to find factors for
        System.out.println("Factors of " + number + " (Iterative):");
        findFactorsIterative(number);
        
        System.out.println("Factors of " + number + " (Recursive):");
        findFactorsRecursive(number, 1);
    }

    // Iterative method
    public static void findFactorsIterative(int num) {
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Recursive method
    public static void findFactorsRecursive(int num, int i) {
        if (i > num) {
            return;
        }
        if (num % i == 0) {
            System.out.print(i + " ");
        }
        findFactorsRecursive(num, i + 1);
    }
}