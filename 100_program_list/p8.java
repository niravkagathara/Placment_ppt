// WAP to find a total odd and total even digit of a given number.
import java.util.Scanner;

public class p8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int oddCount = 0, evenCount = 0;

        while (number > 0) {
            int digit = number % 10;
            if (digit % 2 == 0) evenCount++;
            else oddCount++;
            number /= 10;
        }
        System.out.println("Total Even Digits: " + evenCount);
        System.out.println("Total Odd Digits: " + oddCount);
    }
}