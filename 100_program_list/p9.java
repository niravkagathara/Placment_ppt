// WAP to find whether a number is Odd or Even without using a % operator.
import java.util.Scanner;

public class p9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        if ((number & 1) == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}