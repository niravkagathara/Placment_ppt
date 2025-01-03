// WAP to calculate an angle between hour and minute hand. (Hours and minutes should be taken from user).
import java.util.Scanner;

public class p14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter hours and minutes: ");
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();

        if (hours >= 12) hours -= 12;

        double hourAngle = (hours * 30) + (minutes * 0.5);
        double minuteAngle = minutes * 6;
        double angle = Math.abs(hourAngle - minuteAngle);
        angle = Math.min(angle, 360 - angle); // Smallest angle

        System.out.println("Angle between hour and minute hand: " + angle + " degrees");
    }
}