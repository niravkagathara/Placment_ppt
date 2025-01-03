// WAP to find a Multiplication of 2 Matrix (dimension and value should be entered by user)
import java.util.Scanner;

public class p13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dimensions (rows and columns) of first matrix: ");
        int r1 = scanner.nextInt(), c1 = scanner.nextInt();
        System.out.print("Enter dimensions (rows and columns) of second matrix: ");
        int r2 = scanner.nextInt(), c2 = scanner.nextInt();

        if (c1 != r2) {
            System.out.println("Matrix multiplication not possible.");
            return;
        }

        int[][] matrix1 = new int[r1][c1];
        int[][] matrix2 = new int[r2][c2];
        int[][] result = new int[r1][c2];

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c1){
                matrix1[i][j] = scanner.nextInt();
            }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < r2; i++)
            for (int j = 0; j < c2; j++) {  // Added ';' here
                matrix2[i][j] = scanner.nextInt();
            }

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    result[i][j] += matrix1[i][k] * matrix2[k][j];

        System.out.println("Resultant Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}