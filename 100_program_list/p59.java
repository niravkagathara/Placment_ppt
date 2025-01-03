// WAP to demerge a doubly linked list into 2 list, one list will hold the odd numbers while
// another list will hold only even number.
// Node class for Doubly Linked List
class Node {
    int data;
    Node next;
    Node prev;
    
    // Constructor
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class p59 {
    Node head;
    
    // Function to insert a node at the end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }
    
    // Function to display the list
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    // Function to demerge the list into two lists, one holding even numbers and the other holding odd numbers
    public void demerge(Node originalHead) {
        Node oddHead = null, evenHead = null;
        Node oddTail = null, evenTail = null;
        
        Node temp = originalHead;
        
        // Traverse the original list and separate the nodes into odd and even lists
        while (temp != null) {
            if (temp.data % 2 == 0) { // Even number
                if (evenHead == null) {
                    evenHead = new Node(temp.data);
                    evenTail = evenHead;
                } else {
                    Node newNode = new Node(temp.data);
                    evenTail.next = newNode;
                    newNode.prev = evenTail;
                    evenTail = newNode;
                }
            } else { // Odd number
                if (oddHead == null) {
                    oddHead = new Node(temp.data);
                    oddTail = oddHead;
                } else {
                    Node newNode = new Node(temp.data);
                    oddTail.next = newNode;
                    newNode.prev = oddTail;
                    oddTail = newNode;
                }
            }
            temp = temp.next;
        }
        
        // Display the even and odd lists
        System.out.print("Odd List: ");
        display(oddHead);
        
        System.out.print("Even List: ");
        display(evenHead);
    }
    
    public static void main(String[] args) {
        p59 list = new p59();
        
        // Creating a doubly linked list with some random values
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        
        // Displaying the original list
        System.out.print("Original List: ");
        list.display(list.head);
        
        // Demerging the list into odd and even lists
        list.demerge(list.head);
    }
}
