// WAP to find Max, Min, Average of n numbers, n should be taken from user and all n value should be taken from user (Note that you are not allowed to use an array for this)
import java.util.Scanner;

public class p12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of values: ");
        int n = scanner.nextInt();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter value " + (i + 1) + ": ");
            int value = scanner.nextInt();
            sum += value;
            if (value > max) max = value;
            if (value < min) min = value;
        }
        double average = (double) sum / n;
        System.out.println("Max: " + max + ", Min: " + min + ", Average: " + average);
    }
}