// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

// Definition for a binary tree node
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

public class p86 {

    // Method to convert sorted linked list to height-balanced BST
    public TreeNode sortedListToBST(ListNode head) {
        // Find the size of the linked list
        int size = getSize(head);
        
        // Convert the list to BST using the helper function
        return sortedListToBSTHelper(head, 0, size - 1);
    }

    // Helper function to recursively build the BST
    private TreeNode sortedListToBSTHelper(ListNode head, int start, int end) {
        // Base case: if start > end, return null
        if (start > end) {
            return null;
        }

        // Recurse on the left subtree
        int mid = (start + end) / 2;
        
        // Build the left subtree
        TreeNode left = sortedListToBSTHelper(head, start, mid - 1);
        
        // Create the root node with the current middle element
        TreeNode root = new TreeNode(head.val);
        
        // Move the head pointer to the next node
        head = head.next;
        
        // Build the right subtree
        root.left = left;
        root.right = sortedListToBSTHelper(head, mid + 1, end);
        
        return root;
    }

    // Function to get the size of the linked list
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    // Function to print in-order traversal of the BST (for checking the result)
    public void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        p86 solution = new p86();
        
        // Creating a sorted linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        
        // Convert the sorted linked list to a height-balanced BST
        TreeNode root = solution.sortedListToBST(head);
        
        // Print the in-order traversal of the BST (should be sorted)
        System.out.println("In-order traversal of the BST:");
        solution.inorderTraversal(root);  // Output: 1 2 3 4 5 6 7
    }
}
