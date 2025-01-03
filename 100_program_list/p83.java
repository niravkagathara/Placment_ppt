// Java Program to Implement Inorder, Preorder, and Postorder Traversal in a Binary Search Tree

// Class to represent the node of the BST
class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class p83 {
    Node root;

    public p83() {
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

    // Inorder traversal (Left, Root, Right)
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

    // Preorder traversal (Root, Left, Right)
    public void preorder() {
        preorderRec(root);
    }

    // A recursive function to perform preorder traversal
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postorder() {
        postorderRec(root);
    }

    // A recursive function to perform postorder traversal
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Main method to test the BST operations
    public static void main(String[] args) {
        p83 bst = new p83();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Perform Inorder traversal
        System.out.println("Inorder traversal:");
        bst.inorder(); // Expected Output: 20 30 40 50 60 70 80
        System.out.println();

        // Perform Preorder traversal
        System.out.println("Preorder traversal:");
        bst.preorder(); // Expected Output: 50 30 20 40 70 60 80
        System.out.println();

        // Perform Postorder traversal
        System.out.println("Postorder traversal:");
        bst.postorder(); // Expected Output: 20 40 30 60 80 70 50
    }
}
