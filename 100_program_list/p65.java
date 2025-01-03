// You are given two non-empty linked lists representing two non-negative integers. The digits
// are stored in reverse order, and each of their nodes contains a single digit. Add the two
// numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0
// itself.
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class p65 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to store the result
        ListNode current = dummy; // Pointer to traverse the result list
        int carry = 0; // Variable to store the carry between additions
        
        // Traverse both linked lists until both are null
        while (l1 != null || l2 != null || carry != 0) {
            // Get the values of the current nodes, or 0 if the node is null
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Sum the digits along with the carry
            int sum = x + y + carry;
            
            // Update the carry for the next iteration
            carry = sum / 10;
            
            // Set the next node to the current sum modulo 10
            current.next = new ListNode(sum % 10);
            
            // Move to the next node in the result list
            current = current.next;
            
            // Move to the next node in l1 and l2, if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next; // Return the next node after the dummy node
    }
    
    // Utility function to create a linked list from an array
    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int num : arr) {
            current.next = new ListNode(num);
            current = current.next;
        }
        return dummy.next;
    }
    
    // Utility function to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] l1Arr = {2, 4, 3}; // represents 342
        int[] l2Arr = {5, 6, 4}; // represents 465
        
        ListNode l1 = createLinkedList(l1Arr);
        ListNode l2 = createLinkedList(l2Arr);
        
        ListNode result = addTwoNumbers(l1, l2);
        
        printList(result); // Output: 7 0 8 (represents 807)
    }
}
