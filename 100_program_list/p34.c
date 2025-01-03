// Print a Leaf Nodes in Binary search tree
#include <stdio.h>
#include <stdlib.h>

// Define a structure for the Binary Search Tree node
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Function to create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Function to insert a node in the BST
struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        return createNode(data);
    }
    
    if (data < root->data) {
        root->left = insert(root->left, data);
    } else {
        root->right = insert(root->right, data);
    }

    return root;
}

// Function to print the leaf nodes of the BST
void printLeafNodes(struct Node* root) {
    if (root == NULL) {
        return;
    }

    // If the node is a leaf (both left and right children are NULL)
    if (root->left == NULL && root->right == NULL) {
        printf("%d ", root->data);  // Print the leaf node
    }

    // Recur for left and right subtrees
    printLeafNodes(root->left);
    printLeafNodes(root->right);
}

int main() {
    struct Node* root = NULL;

    // Insert nodes into the BST
    root = insert(root, 50);
    root = insert(root, 30);
    root = insert(root, 20);
    root = insert(root, 40);
    root = insert(root, 70);
    root = insert(root, 60);
    root = insert(root, 80);

    // Print the leaf nodes
    printf("Leaf Nodes in the Binary Search Tree: ");
    printLeafNodes(root);
    printf("\n");

    return 0;
}
