import java.util.*;

class p90 {
    // Edge class to represent an edge between two vertices with weight
    static class Edge {
        int src, dest, weight;

        // Constructor
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Disjoint Set (Union-Find) data structure
    static class DisjointSet {
        int[] parent, rank;

        // Constructor to initialize disjoint set
        DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        // Find the parent of a node with path compression
        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union by rank
        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    // Kruskal's algorithm to find the MST of a graph
    public static List<Edge> kruskal(int V, List<Edge> edges) {
        // Sort all edges in non-decreasing order of weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        DisjointSet ds = new DisjointSet(V);
        List<Edge> mst = new ArrayList<>();

        // Process all edges
        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            // If including this edge does not form a cycle, include it in the MST
            if (ds.find(src) != ds.find(dest)) {
                mst.add(edge);
                ds.union(src, dest);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        // Number of vertices
        int V = 4;
        
        // List to store all edges
        List<Edge> edges = new ArrayList<>();
        
        // Adding edges (src, dest, weight)
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        // Run Kruskal's algorithm to find the MST
        List<Edge> mst = kruskal(V, edges);

        // Print the edges in the MST
        System.out.println("Edges in the MST:");
        int mstWeight = 0;
        for (Edge edge : mst) {
            System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
            mstWeight += edge.weight;
        }
        
        System.out.println("Total weight of the MST: " + mstWeight);
    }
}
