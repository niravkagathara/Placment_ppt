// Java Program to Implement a Binary Search Tree with Insert and Delete Operations

// Class to represent the node of the BST
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class p82 {
    Node root;

    public p82() {
        root = null;
    }

    // Insert a new node into the BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in the BST
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        }

        // return the (unchanged) node pointer
        return root;
    }

    // Delete a node from the BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a node from the BST
    private Node deleteRec(Node root, int key) {
        // Base case: if the tree is empty
        if (root == null) {
            return root;
        }

        // If the key to be deleted is smaller than the root's data, then it lies in the left subtree
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        }
        // If the key to be deleted is greater than the root's data, then it lies in the right subtree
        else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        }
        // If the key is the same as the root's data, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    // Utility function to find the minimum value node in the right subtree
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // Inorder traversal of the BST
    public void inorder() {
        inorderRec(root);
    }

    // A recursive function to perform inorder traversal
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the BST operations
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        System.out.println("Inorder traversal of the BST:");
        bst.inorder(); // Output: 20 30 40 50 60 70 80
        System.out.println();

        // Delete a node
        System.out.println("\nDelete 20:");
        bst.delete(20);
        bst.inorder(); // Output: 30 40 50 60 70 80
        System.out.println();

        // Delete a node with two children
        System.out.println("\nDelete 30:");
        bst.delete(30);
        bst.inorder(); // Output: 40 50 60 70 80
        System.out.println();

        // Delete a node with one child
        System.out.println("\nDelete 70:");
        bst.delete(70);
        bst.inorder(); // Output: 40 50 60 80
        System.out.println();

        // Delete the root node
        System.out.println("\nDelete 50:");
        bst.delete(50);
        bst.inorder(); // Output: 40 60 80
    }
}
