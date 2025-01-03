import java.util.Arrays;

public class p100 {
    static final int INF = 99999; // Representing infinity

    public static void main(String[] args) {
        // Number of vertices
        int V = 4;

        // Input graph as adjacency matrix
        int[][] graph = {
            {0, 8, INF, 4}, // Node 1
            {INF, 0, 1, INF}, // Node 2
            {INF, INF, 0, 2}, // Node 3
            {4, 9, INF, 0}  // Node 4
        };

        // Call Floyd-Warshall Algorithm
        floydWarshall(graph, V);
    }

    static void floydWarshall(int[][] graph, int V) {
        // Create a distance matrix initialized with input graph
        int[][] dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // Run Floyd-Warshall Algorithm
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Print the shortest distances
        printSolution(dist, V);
    }

    static void printSolution(int[][] dist, int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}
