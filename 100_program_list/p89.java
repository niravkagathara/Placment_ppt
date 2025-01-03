import java.util.*;

class Graph {
    // Number of vertices
    private int V;

    // Adjacency list to store the graph
    private List<List<Node>> adjList;

    // Constructor to initialize the graph with V vertices
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>();
        
        // Initialize adjacency list for each vertex
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Node(v, weight));
        adjList.get(v).add(new Node(u, weight)); // For undirected graph
    }

    // Dijkstra's Algorithm to find the shortest path
    public int[] dijkstra(int source) {
        // Create a distance array and initialize all distances as infinity
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;  // Distance to source is 0

        // Priority queue to store (vertex, distance) pairs
        // The priority queue will automatically sort by distance
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        pq.add(new Node(source, 0));

        // Set to keep track of visited nodes
        boolean[] visited = new boolean[V];

        // Main Dijkstra's loop
        while (!pq.isEmpty()) {
            Node current = pq.poll();  // Get the node with the smallest distance

            int u = current.vertex;

            // Skip the node if it has already been visited
            if (visited[u]) continue;

            visited[u] = true;

            // Update distances to all unvisited neighbors of u
            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.distance;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));  // Add the updated distance to the priority queue
                }
            }
        }

        return dist;
    }

    // Inner class to represent a node (vertex, distance pair)
    static class Node {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

public class p89 {
    public static void main(String[] args) {
        // Number of vertices in the graph
        int V = 9;

        // Create the graph
        Graph graph = new Graph(V);

        // Add edges (u, v, weight)
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        // Run Dijkstra's algorithm from source node 0
        int[] shortestPaths = graph.dijkstra(0);

        // Print shortest distances from the source (node 0)
        System.out.println("Shortest distances from source node 0:");
        for (int i = 0; i < V; i++) {
            System.out.println("Distance to node " + i + ": " + (shortestPaths[i] == Integer.MAX_VALUE ? "INF" : shortestPaths[i]));
        }
    }
}
