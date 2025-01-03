// *********
// **** ****  
// ***   ***  
// **     **  
// *       *  
public class p22c {
    public static void main(String[] args) {
        int n = 5; // Number of rows

        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j < i; j++) {
                System.out.print(" ");
            }

            // Print the first block of stars
            for (int j = 1; j <= n - i + 1; j++) {
                System.out.print("*");
            }

            // Print spaces between the two blocks of stars
            for (int j = 1; j <= 2 * i - 3; j++) {
                System.out.print(" ");
            }

            // Print the second block of stars
            if (i != n) { // Avoid printing stars on the last row twice
                for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print("*");
                }
            }

            // Move to the next line
            System.out.println();
        }
    }
}
