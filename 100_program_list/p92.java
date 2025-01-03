class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class p92 {
    public static void main(String[] args) {
        // Define your inorder and postorder arrays here
        int[] inorder = { 1, 2, 3 }; // Fill in the elements of your inorder array
        int[] postorder = { 3, 2, 1 }; // Fill in the elements of your postorder array
        
        p92 treeBuilder = new p92();
        TreeNode root = treeBuilder.buildTree(inorder, postorder);
        
        // You can use the tree here, such as printing it
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        
        // Find the index of the root in inorder array
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the size of the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        if (leftSize > 0) { // Check if there is a left subtree
            root.left = buildTreeHelper(inorder, postorder, inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        }
        if (rootIndex < inEnd) { // Check if there is a right subtree
            root.right = buildTreeHelper(inorder, postorder, rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
        }
        
        return root;
    }
}
