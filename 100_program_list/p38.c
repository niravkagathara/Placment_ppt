// WAP to add an element into already sorted singly linked list.
#include <stdio.h>
#include <stdlib.h>

// Node structure for the singly linked list
struct Node {
    int data;
    struct Node* next;
};

// Function to create a new node
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->next = NULL;
    return node;
}

// Function to insert a node into the sorted linked list
void insertSorted(struct Node** head, int data) {
    struct Node* new_node = newNode(data);
    
    // Case 1: If the list is empty or the new element is smaller than the head
    if (*head == NULL || (*head)->data >= data) {
        new_node->next = *head;
        *head = new_node;
        return;
    }

    // Case 2: Find the correct position in the list
    struct Node* current = *head;
    while (current->next != NULL && current->next->data < data) {
        current = current->next;
    }

    // Insert the new node
    new_node->next = current->next;
    current->next = new_node;
}

// Function to print the linked list
void printList(struct Node* head) {
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    struct Node* head = NULL;

    // Insert elements into the sorted linked list
    insertSorted(&head, 10);
    insertSorted(&head, 20);
    insertSorted(&head, 30);
    insertSorted(&head, 15);  // Insert in the middle
    insertSorted(&head, 5);   // Insert at the beginning
    insertSorted(&head, 25);  // Insert at the end

    printf("Sorted Linked List after insertion: \n");
    printList(head);

    return 0;
}


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

//     // Function to insert a new node into the sorted linked list
//     public void insertSorted(int data) {
//         Node newNode = new Node(data);

//         // Case 1: If the list is empty or the new element is smaller than the head
//         if (head == null || head.data >= data) {
//             newNode.next = head;
//             head = newNode;
//             return;
//         }

//         // Case 2: Traverse the list and find the correct position
//         Node current = head;
//         while (current.next != null && current.next.data < data) {
//             current = current.next;
//         }

//         // Insert the new node
//         newNode.next = current.next;
//         current.next = newNode;
//     }

//     // Function to print the linked list
//     public void printList() {
//         Node temp = head;
//         while (temp != null) {
//             System.out.print(temp.data + " ");
//             temp = temp.next;
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         LinkedList list = new LinkedList();

//         // Insert elements into the sorted linked list
//         list.insertSorted(10);
//         list.insertSorted(20);
//         list.insertSorted(30);
//         list.insertSorted(15);  // Insert in the middle
//         list.insertSorted(5);   // Insert at the beginning
//         list.insertSorted(25);  // Insert at the end

//         System.out.println("Sorted Linked List after insertion:");
//         list.printList();
//     }
// }
