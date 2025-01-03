
// class LinkedList {
//     // Node class representing each element of the linked list
//     class Node {
//         int data;
//         Node next;
        
//         // Constructor to create a new node
//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     Node head;

//     // Merge sort function for the linked list
//     public Node mergeSort(Node head) {
//         if (head == null || head.next == null) {
//             return head; // Base case: if list has 0 or 1 node, it's already sorted
//         }

//         Node middle = getMiddle(head);
//         Node nextOfMiddle = middle.next;

//         middle.next = null; // Split the list into two halves

//         // Recursively sort both halves
//         Node left = mergeSort(head);
//         Node right = mergeSort(nextOfMiddle);

//         // Merge the sorted halves
//         return merge(left, right);
//     }

//     // Function to find the middle of the linked list
//     public Node getMiddle(Node head) {
//         if (head == null) return head;

//         Node slow = head;
//         Node fast = head;

//         while (fast != null && fast.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         return slow;
//     }

//     // Function to merge two sorted linked lists
//     public Node merge(Node left, Node right) {
//         if (left == null) return right;
//         if (right == null) return left;

//         if (left.data <= right.data) {
//             left.next = merge(left.next, right);
//             return left;
//         } else {
//             right.next = merge(left, right.next);
//             return right;
//         }
//     }

//     // Function to print the linked list
//     public void printList(Node head) {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     // Function to push a new node at the end of the list
//     public void append(int data) {
//         Node newNode = new Node(data);
//         if (head == null) {
//             head = newNode;
//         } else {
//             Node temp = head;
//             while (temp.next != null) {
//                 temp = temp.next;
//             }
//             temp.next = newNode;
//         }
//     }

//     public static void main(String[] args) {
//         LinkedList list = new LinkedList();
        
//         // Adding elements to the linked list
//         list.append(10);
//         list.append(30);
//         list.append(20);
//         list.append(5);
//         list.append(15);

//         System.out.println("Original Linked List:");
//         list.printList(list.head);

//         // Sorting the linked list using Merge Sort
//         list.head = list.mergeSort(list.head);

//         System.out.println("Sorted Linked List:");
//         list.printList(list.head);
//     }
// }
