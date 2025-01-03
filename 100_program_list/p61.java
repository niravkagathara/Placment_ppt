// Given the root of a binary search tree (BST) with duplicates, return all the node(s) (i.e., the
// most frequently occurred element) in it.
import java.util.*;

// TreeNode class representing the structure of a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class p61 {

    // Helper function to perform in-order traversal and update frequency
    private static void inOrderTraversal(TreeNode root, Map<Integer, Integer> freqMap) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left, freqMap);
        freqMap.put(root.val, freqMap.getOrDefault(root.val, 0) + 1);
        inOrderTraversal(root.right, freqMap);
    }

    // Function to return the most frequent element(s)
    public static List<Integer> findMode(TreeNode root) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        inOrderTraversal(root, freqMap);

        int maxFrequency = 0;
        // Find the maximum frequency
        for (int frequency : freqMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Collect all the elements that have the maximum frequency
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    // Driver code
    public static void main(String[] args) {
        // Creating a BST with duplicates
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);

        // Find and print the most frequent elements
        List<Integer> result = findMode(root);
        System.out.println("Most frequent element(s): " + result);
    }
}
