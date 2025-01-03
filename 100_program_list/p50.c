// WAP to count the degree of each vertex in a directed Graph (where graph is created using
// edges means if user input 1 2 then there is a directed edge from node 1 to node 2 user enter
// -1 for stop entering the edge)
#include <stdio.h>

#define MAX_VERTICES 100

// Function to count the degree of each vertex
void countDegree(int graph[MAX_VERTICES][MAX_VERTICES], int n) {
    int in_degree[MAX_VERTICES] = {0};  // To store in-degree of each vertex
    int out_degree[MAX_VERTICES] = {0}; // To store out-degree of each vertex

    // Calculate in-degree and out-degree for each vertex
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (graph[i][j] == 1) {  // Edge exists from i to j
                out_degree[i]++;  // Increase out-degree of i
                in_degree[j]++;   // Increase in-degree of j
            }
        }
    }

    // Print the in-degree and out-degree of each vertex
    for (int i = 0; i < n; i++) {
        printf("Vertex %d: In-degree = %d, Out-degree = %d\n", i, in_degree[i], out_degree[i]);
    }
}

int main() {
    int n, u, v;

    // Input the number of vertices
    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    // Initialize the graph with 0 (no edges)
    int graph[MAX_VERTICES][MAX_VERTICES] = {0};

    // Input edges until user enters -1
    printf("Enter edges as pairs of vertices (u v), enter -1 to stop:\n");
    while (1) {
        scanf("%d", &u);
        if (u == -1) {
            break;  // Stop when user enters -1
        }
        scanf("%d", &v);
        if (u >= 0 && u < n && v >= 0 && v < n) {
            graph[u][v] = 1;  // Directed edge from u to v
        } else {
            printf("Invalid vertices. Please enter valid vertices between 0 and %d.\n", n-1);
        }
    }

    // Call the function to count the degree of each vertex
    countDegree(graph, n);

    return 0;
}
