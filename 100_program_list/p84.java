// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class p84 {
    
    // Method to invert the binary tree
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the tree is empty
        if (root == null) {
            return null;
        }
        
        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        // Swap the left and right subtrees
        root.left = right;
        root.right = left;
        
        return root;
    }

    // Method to print in-order traversal of the tree
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        p84 tree = new p84();
        
        // Creating a binary tree: 4 / \ 2 7 / \ / \ 1 3 6 9
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        
        // Before inversion
        System.out.println("In-order traversal of original tree:");
        tree.inorderTraversal(root); // Output: 1 2 3 4 6 7 9
        System.out.println();
        
        // Inverting the tree
        root = tree.invertTree(root);
        
        // After inversion
        System.out.println("In-order traversal of inverted tree:");
        tree.inorderTraversal(root); // Output: 9 7 6 4 3 2 1
    }
}
