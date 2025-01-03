// WAP to implement a DFS traversal technique in a Graph
#include <stdio.h>
#include <stdlib.h>

#define MAX 100

// DFS function
void dfs(int graph[MAX][MAX], int visited[MAX], int node, int n) {
    // Mark the node as visited and print it
    visited[node] = 1;
    printf("%d ", node);

    // Visit all the unvisited neighbors of the current node
    for (int i = 0; i < n; i++) {
        if (graph[node][i] == 1 && !visited[i]) {
            dfs(graph, visited, i, n);  // Recursive DFS call
        }
    }
}

int main() {
    int n, m, u, v;

    // Input the number of nodes and edges
    printf("Enter the number of nodes: ");
    scanf("%d", &n);
    printf("Enter the number of edges: ");
    scanf("%d", &m);

    // Initialize the graph with 0 (no edges)
    int graph[MAX][MAX] = {0};

    printf("Enter the edges (u v) where there's an edge between u and v:\n");
    for (int i = 0; i < m; i++) {
        scanf("%d %d", &u, &v);
        graph[u][v] = 1;  // For undirected graph
        graph[v][u] = 1;  // For undirected graph
    }

    int visited[MAX] = {0};  // To keep track of visited nodes
    int start;
    printf("Enter the start node for DFS: ");
    scanf("%d", &start);

    printf("DFS Traversal starting from node %d: ", start);
    dfs(graph, visited, start, n);  // Call the DFS function
    printf("\n");

    return 0;
}
// #include <stdio.h>
// #include <stdlib.h>

// #define MAX 100

// // Iterative DFS using a stack
// void dfs_iterative(int graph[MAX][MAX], int n, int start) {
//     int visited[MAX] = {0};  // To keep track of visited nodes
//     int stack[MAX], top = -1;  // Stack for DFS
    
//     // Push the starting node onto the stack
//     stack[++top] = start;
//     visited[start] = 1;
    
//     printf("DFS Traversal starting from node %d: ", start);
    
//     while (top != -1) {
//         int node = stack[top--];  // Pop the top node from the stack
//         printf("%d ", node);
        
//         // Push all unvisited neighbors onto the stack
//         for (int i = n - 1; i >= 0; i--) {
//             if (graph[node][i] == 1 && !visited[i]) {
//                 visited[i] = 1;
//                 stack[++top] = i;
//             }
//         }
//     }
//     printf("\n");
// }

// int main() {
//     int n, m, u, v;

//     // Input the number of nodes and edges
//     printf("Enter the number of nodes: ");
//     scanf("%d", &n);
//     printf("Enter the number of edges: ");
//     scanf("%d", &m);

//     // Initialize the graph with 0 (no edges)
//     int graph[MAX][MAX] = {0};

//     printf("Enter the edges (u v) where there's an edge between u and v:\n");
//     for (int i = 0; i < m; i++) {
//         scanf("%d %d", &u, &v);
//         graph[u][v] = 1;  // For undirected graph
//         graph[v][u] = 1;  // For undirected graph
//     }

//     int start;
//     printf("Enter the start node for DFS: ");
//     scanf("%d", &start);

//     // Call the DFS function (Iterative)
//     dfs_iterative(graph, n, start);

//     return 0;
// }
