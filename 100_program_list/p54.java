// You have n super washing machines on a line. Initially, each washing machine has some
// dresses or is empty.
// For each move, you could choose any m (1 <= m <= n) washing machines, and pass one dress
// of each washing machine to one of its adjacent washing machines at the same time.
// Given an integer array machine representing the number of dresses in each washing machine
// from left to right on the line, return the minimum number of moves to make all the washing
// machines have the same number of dresses. If it is not possible to do it, return -1.
// Input: machines = [1,0,5]
// Output: 3
// Explanation:
// 1st move: 1 0 <-- 5 => 1 1 4
// 2nd move: 1 <-- 1 <-- 4 => 2 1 3
// 3rd move: 2 1 <-- 3 => 2 2 2
// Input: machines = [0,3,0]
// Output: 2
// Explanation: 
// 1st move: 0 <-- 3 0 => 1 2 0 
// 2nd move: 1 2 --> 0 => 1 1 1

public class p54 {
    public static int findMinMoves(int[] machines) {
        int n = machines.length;
        int totalDresses = 0;

        // Calculate total dresses in all machines
        for (int dresses : machines) {
            totalDresses += dresses;
        }

        // If total dresses cannot be evenly distributed, return -1
        if (totalDresses % n != 0) {
            return -1;
        }

        int target = totalDresses / n;
        int maxMoves = 0;
        int currentBalance = 0; // Track the current balance of dresses

        // Traverse through each machine
        for (int dresses : machines) {
            int balance = dresses - target;

            // Update maxMoves by considering the balance and current balance
            maxMoves = Math.max(maxMoves, Math.abs(balance));
            maxMoves = Math.max(maxMoves, currentBalance + balance);

            // Update current balance for the next machine
            currentBalance += balance;
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        int[] machines1 = {1, 0, 5};
        int[] machines2 = {0, 3, 0};
        
        System.out.println(findMinMoves(machines1));  // Output: 3
        System.out.println(findMinMoves(machines2));  // Output: 2
    }
}
