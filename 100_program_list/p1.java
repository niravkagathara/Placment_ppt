// WAP to find a sum of even number into 1D array.

public class p1 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6}; 
        int sum = 0;

        for (int num : array) {
            if (num % 2 == 0) { 
                sum += num;
            }
        }

        System.out.println("sum" + sum);
    }
}