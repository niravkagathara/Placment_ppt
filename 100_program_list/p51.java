// In a Given BST (Binary) search tree find the 2nd min value
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class p51 {
    TreeNode root;

    // Function to find the second minimum value
    public int findSecondMinimumValue(TreeNode root) {
        // If the root is null or does not have both left and right children, return -1
        if (root == null || root.left == null || root.right == null) {
            return -1;
        }

        // Initialize the second minimum
        int[] result = new int[]{Integer.MAX_VALUE};
        
        // Helper function to perform inorder traversal and find the second minimum
        inorderTraversal(root, result, root.val);
        
        // If second minimum is not updated, return -1
        return result[0] == Integer.MAX_VALUE ? -1 : result[0];
    }

    // Helper function to perform inorder traversal
    private void inorderTraversal(TreeNode node, int[] result, int firstMin) {
        if (node == null) {
            return;
        }
        
        // If the node's value is greater than the first minimum and smaller than the current second minimum
        if (node.val > firstMin && node.val < result[0]) {
            result[0] = node.val;
        }

        // Recurse to the left and right child
        inorderTraversal(node.left, result, firstMin);
        inorderTraversal(node.right, result, firstMin);
    }

    public static void main(String[] args) {
        p51 tree = new p51();
        tree.root = new TreeNode(2);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(7);
        
        int secondMin = tree.findSecondMinimumValue(tree.root);
        System.out.println("The second minimum value is: " + secondMin);
    }
}
