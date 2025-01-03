// Java program to print the leaf nodes of a Binary Search Tree

class p34 {
    
    // Define the structure of the Node
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    // Root of the Binary Search Tree
    Node root;

    // Constructor
    public p34() {
        root = null;
    }

    // Function to insert a new node in the BST
    public Node insert(Node root, int data) {
        // If the tree is empty, create a new node
        if (root == null) {
            root = new Node(data);
            return root;
        }

        // Otherwise, recur down the tree
        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        // return the (unchanged) node pointer
        return root;
    }

    // Function to print all leaf nodes in the Binary Search Tree
    public void printLeafNodes(Node root) {
        if (root == null) {
            return;
        }

        // If both left and right children are null, it's a leaf node
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        // Recur for left and right subtrees
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        p34 tree = new p34();

        // Insert nodes into the Binary Search Tree
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 70);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 80);

        // Print leaf nodes in the tree
        System.out.println("Leaf Nodes in the Binary Search Tree:");
        tree.printLeafNodes(tree.root);
    }
}
