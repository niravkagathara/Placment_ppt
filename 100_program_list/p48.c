// WAP to implement a BFS traversal technique in a Graph.
#include <stdio.h>
#include <stdlib.h>

// Define the maximum number of nodes in the graph
#define MAX 100

// Queue structure to hold nodes during BFS traversal
struct Queue {
    int items[MAX];
    int front;
    int rear;
};

// Initialize the queue
void initQueue(struct Queue* q) {
    q->front = -1;
    q->rear = -1;
}

// Check if the queue is empty
int isEmpty(struct Queue* q) {
    return q->front == -1;
}

// Enqueue an element to the queue
void enqueue(struct Queue* q, int value) {
    if (q->rear == MAX - 1) {
        printf("Queue is full\n");
    } else {
        if (q->front == -1) {
            q->front = 0;
        }
        q->rear++;
        q->items[q->rear] = value;
    }
}

// Dequeue an element from the queue
int dequeue(struct Queue* q) {
    if (isEmpty(q)) {
        printf("Queue is empty\n");
        return -1;
    } else {
        int item = q->items[q->front];
        q->front++;
        if (q->front > q->rear) {
            q->front = q->rear = -1;
        }
        return item;
    }
}

// BFS function
void bfs(int graph[MAX][MAX], int start, int n) {
    int visited[MAX] = {0};  // Array to keep track of visited nodes
    struct Queue q;
    initQueue(&q);
    
    // Mark the starting node as visited and enqueue it
    visited[start] = 1;
    enqueue(&q, start);
    
    while (!isEmpty(&q)) {
        // Dequeue a node from the queue
        int node = dequeue(&q);
        printf("%d ", node);
        
        // Visit all the unvisited neighbors of the dequeued node
        for (int i = 0; i < n; i++) {
            if (graph[node][i] == 1 && !visited[i]) {  // If there's an edge and the node is unvisited
                visited[i] = 1;  // Mark as visited
                enqueue(&q, i);   // Enqueue the node
            }
        }
    }
}

int main() {
    int n, m, u, v;

    printf("Enter the number of nodes: ");
    scanf("%d", &n);
    printf("Enter the number of edges: ");
    scanf("%d", &m);
    
    // Create an adjacency matrix to represent the graph
    int graph[MAX][MAX] = {0};

    printf("Enter the edges (u v) where there's an edge between u and v:\n");
    for (int i = 0; i < m; i++) {
        scanf("%d %d", &u, &v);
        graph[u][v] = 1;  // Undirected graph
        graph[v][u] = 1;  // Undirected graph
    }

    int start;
    printf("Enter the start node for BFS: ");
    scanf("%d", &start);

    printf("BFS Traversal starting from node %d: ", start);
    bfs(graph, start, n);
    printf("\n");

    return 0;
}
