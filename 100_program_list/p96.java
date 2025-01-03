import java.util.*;

public class p96 {
    public static List<List<Integer>> findPlayers(int[][] matches) {
        Set<Integer> winners = new HashSet<>(); // Players who have won at least one match
        Set<Integer> losers = new HashSet<>();  // Players who have lost at least one match
        Set<Integer> oneLoss = new HashSet<>(); // Players who have lost exactly one match

        // Process each match
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // If the loser has already lost, remove from oneLoss and add to losers
            if (oneLoss.contains(loser)) {
                oneLoss.remove(loser);
            }
            losers.add(loser); // Mark the player as a loser
            oneLoss.add(loser); // Initially, we assume the player has one loss

            winners.add(winner); // Mark the player as a winner
        }

        // Players who have never lost a match
        List<Integer> noLoss = new ArrayList<>();
        for (int player : winners) {
            if (!losers.contains(player)) {
                noLoss.add(player);
            }
        }

        // Sorting both lists
        Collections.sort(noLoss);
        List<Integer> oneLossList = new ArrayList<>(oneLoss);
        Collections.sort(oneLossList);

        // Prepare the result
        List<List<Integer>> result = new ArrayList<>();
        result.add(noLoss);
        result.add(oneLossList);

        return result;
    }

    public static void main(String[] args) {
        int[][] matches = {
            {1, 3},
            {2, 3},
            {3, 6},
            {5, 6},
            {5, 7},
            {4, 5},
            {4, 8},
            {4, 9},
            {10, 4},
            {10, 9}
        };
        
        List<List<Integer>> result = findPlayers(matches);
        
        // Print the result
        System.out.println(result);
    }
}
