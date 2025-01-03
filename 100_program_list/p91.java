import java.util.*;

class p90 {
    static class Edge {
        int src, dest, weight;

        // Constructor
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Graph representation using adjacency list
    static class Graph {
        int V;
        List<Edge> adj[];

        // Constructor
        Graph(int V) {
            this.V = V;
            adj = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }
        }

        // Add edge to the graph
        void addEdge(int u, int v, int weight) {
            adj[u].add(new Edge(u, v, weight));
            adj[v].add(new Edge(v, u, weight));  // For undirected graph
        }

        // Prim's Algorithm to find MST
        void primMST() {
            // Min-heap to get the edge with the smallest weight
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            boolean[] inMST = new boolean[V];
            int[] key = new int[V];  // To store the minimum weight edge for each vertex
            int[] parent = new int[V]; // To store the parent of each vertex in the MST

            // Initialize key values and parent for each vertex
            Arrays.fill(key, Integer.MAX_VALUE);
            Arrays.fill(parent, -1);
            key[0] = 0;  // Start from vertex 0
            pq.add(new Edge(-1, 0, 0));  // Start from vertex 0 with 0 weight

            while (!pq.isEmpty()) {
                // Extract vertex with minimum key value
                Edge edge = pq.poll();
                int u = edge.dest;

                // If the vertex is already included in the MST, skip it
                if (inMST[u]) continue;

                // Include the vertex in MST
                inMST[u] = true;

                // Traverse all adjacent vertices of u
                for (Edge e : adj[u]) {
                    int v = e.dest;
                    int weight = e.weight;

                    // If v is not in MST and weight of edge u-v is smaller than the current key value of v
                    if (!inMST[v] && weight < key[v]) {
                        key[v] = weight;
                        pq.add(new Edge(u, v, weight)); // Add the edge to the priority queue
                        parent[v] = u;  // Set the parent of v to be u
                    }
                }
            }

            // Print the MST
            printMST(parent);
        }

        // Function to print the MST
        void printMST(int[] parent) {
            System.out.println("Edge \tWeight");
            for (int i = 1; i < V; i++) {
                int p = parent[i];
                // Declare p as final to use it in the lambda expression
                final int finalP = p;  
                System.out.println(finalP + " - " + i + "\t" + adj[i].stream()
                        .filter(e -> (e.src == finalP && e.dest == i) || (e.src == i && e.dest == finalP))
                        .findFirst().get().weight);
            }
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges (src, dest, weight)
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        // Find MST using Prim's Algorithm
        graph.primMST();
    }
}