// WAP to convert a Decimal number to BCD.
import java.util.Scanner;

public class p15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int number = scanner.nextInt();
        StringBuilder bcd = new StringBuilder();

        while (number > 0) {
            int digit = number % 10;
            bcd.insert(0, String.format("%4s", Integer.toBinaryString(digit)).replace(' ', '0'));
            number /= 10;
        }
        System.out.println("BCD: " + bcd);
    }
}