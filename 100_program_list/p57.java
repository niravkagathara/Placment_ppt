// Write a Function that returns either 1 or 0 based on following condition if the array is in
// ascending order and occurrence of that number at least 3 then it should return 1 otherwise
// it should return 0.
// e.g.
// if A=[1,1,1,2,2] it should return 0
// if A=[1,1,1,3,3,3,3] it should return 1
// if A=[2,2,2,1,1,1] it should return 0

import java.util.HashMap;

public class p57 {
    public int checkArray(int[] A) {
        // Check if the array is in ascending order
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return 0; // Array is not in ascending order
            }
        }

        // Check if any element appears at least 3 times
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : A) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // If any number has occurred at least 3 times, return 1
        for (int count : freqMap.values()) {
            if (count >= 3) {
                return 1;
            }
        }

        return 0; // No number appears at least 3 times
    }

    public static void main(String[] args) {
        p57 solution = new p57();

        // Test cases
        int[] A1 = {1, 1, 1, 2, 2};
        System.out.println(solution.checkArray(A1)); // Output: 0

        int[] A2 = {1, 1, 1, 3, 3, 3, 3};
        System.out.println(solution.checkArray(A2)); // Output: 1

        int[] A3 = {2, 2, 2, 1, 1, 1};
        System.out.println(solution.checkArray(A3)); // Output: 0
    }
}
