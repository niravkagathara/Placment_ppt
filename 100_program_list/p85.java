import java.util.Queue;
import java.util.LinkedList;
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class p85 {

    // Method to add a row at the given depth
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // If depth is 1, we add a new root node with value 'val'
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        // Perform level order traversal to find nodes at depth - 1
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currentDepth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            currentDepth++;

            // Process nodes level by level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                // If we have reached the level before the desired depth, add new nodes
                if (currentDepth == depth) {
                    TreeNode tempLeft = currentNode.left;
                    TreeNode tempRight = currentNode.right;

                    // Insert new nodes
                    currentNode.left = new TreeNode(val);
                    currentNode.right = new TreeNode(val);

                    // Assign the previous children to the new nodes
                    currentNode.left.left = tempLeft;
                    currentNode.right.right = tempRight;
                }

                // Add left and right children to the queue for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return root;
    }

    // Method to print the tree (Inorder traversal for testing)
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    // Main method to test the addOneRow functionality
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        System.out.println("Original tree (Inorder traversal):");
        p85 tree = new p85();
        tree.inorder(root);
        System.out.println();

        // Add a row of nodes with value 1 at depth 3
        root = tree.addOneRow(root, 1, 3);

        System.out.println("Tree after adding row (Inorder traversal):");
        tree.inorder(root);
    }
}
