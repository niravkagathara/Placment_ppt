// WAP to sort an Array using Tree sort. 
#include <stdio.h>
#include <stdlib.h>

// Structure of a Binary Search Tree Node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node with the given value
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

// Function to insert a node in the BST
struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        return newNode(data); // If the tree is empty, insert the node here
    }

    // Otherwise, recursively insert into the left or right subtree
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }

    return root;
}

// In-order traversal of the BST (to get the elements in sorted order)
void inorderTraversal(struct Node* root) {
    if (root != NULL) {
        inorderTraversal(root->left);  // Visit left subtree
        printf("%d ", root->data);     // Print the current node
        inorderTraversal(root->right); // Visit right subtree
    }
}

// Function to perform Tree Sort
void treeSort(int arr[], int n) {
    struct Node* root = NULL;

    // Insert each element from the array into the BST
    for (int i = 0; i < n; i++) {
        root = insert(root, arr[i]);
    }

    // Perform an in-order traversal to print the elements in sorted order
    printf("Sorted Array: ");
    inorderTraversal(root);
    printf("\n");
}

int main() {
    int n;

    // Reading the size of the array
    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int arr[n];  // Array of size n

    // Reading elements of the array
    printf("Enter %d elements: \n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    // Sorting the array using tree sort
    treeSort(arr, n);

    return 0;
}
