import java.util.*;

public class p97 {

    public static int longestCycle(int[] edges) {
        int n = edges.length;
        int longest = -1;
        
        // States for the nodes:
        // 0 -> unvisited, 1 -> visiting (currently in the path), 2 -> fully processed
        int[] visited = new int[n];

        // Traverse each node
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                // Start DFS from this node
                int cycleLength = detectCycle(edges, visited, i);
                if (cycleLength > 0) {
                    longest = Math.max(longest, cycleLength);
                }
            }
        }

        return longest;
    }

    private static int detectCycle(int[] edges, int[] visited, int node) {
        // Stack to track the nodes in the current traversal path
        List<Integer> path = new ArrayList<>();
        
        int current = node;
        while (current != -1 && visited[current] != 2) {
            if (visited[current] == 1) {
                // Cycle detected
                int cycleStart = current;
                int cycleLength = 0;
                
                // Count the cycle length
                for (int i = path.size() - 1; i >= 0; i--) {
                    cycleLength++;
                    if (path.get(i) == cycleStart) {
                        break;
                    }
                }
                return cycleLength;
            }
            
            // Mark the node as visiting (part of the current path)
            visited[current] = 1;
            path.add(current);
            
            // Move to the next node in the chain
            current = edges[current];
        }

        // Mark all the nodes in the current path as fully processed
        for (int nodeInPath : path) {
            visited[nodeInPath] = 2;
        }

        return 0;  // No cycle found
    }

    public static void main(String[] args) {
        int[] edges = {2, 2, 3, 1, -1};
        int result = longestCycle(edges);
        System.out.println("Longest Cycle Length: " + result);
    }
}
