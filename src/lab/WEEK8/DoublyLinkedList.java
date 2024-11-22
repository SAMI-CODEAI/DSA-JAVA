package lab.WEEK8;
import java.util.*;
import java.lang.*;

// Java program to implement all functions used in Doubly Linked List

// Node for Doubly Linked List
class Node {
    int key;
    Node prev;
    Node next;

    Node() {
        prev = null;
        next = null;
    }
}

class Main {
    static Node head = null;
    static Node first = null;
    static Node tail = null;
    static Node temp = null;
    static int i = 0;

    // Function to add a node in the Doubly Linked List
    static void addNode(int k) {
        // Allocating memory to the Node ptr
        Node ptr = new Node();

        // Assign Key to value k
        ptr.key = k;

        // Next and prev pointer to NULL
        ptr.next = null;
        ptr.prev = null;

        // If Linked List is empty
        if (head == null) {
            head = ptr;
            first = head;
            tail = head;
        } else {
            // Else insert at the end of the Linked List
            temp = ptr;
            first.next = temp;
            temp.prev = first;
            first = temp;
            tail = temp;
        }

        // Increment for number of Nodes in the Doubly Linked List
        i++;
    }

    // Function to traverse the Doubly Linked List
    static void traverse() {
        // Nodes points towards head node
        Node ptr = head;

        // While pointer is not NULL, traverse and print the node
        while (ptr != null) {
            // Print key of the node
            System.out.print(ptr.key + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    // Function to insert a node at the beginning of the linked list
    static void insertAtBegin(int k) {
        // Allocating memory to the Node ptr
        Node ptr = new Node();

        // Assign Key to value k
        ptr.key = k;

        // Next and prev pointer to NULL
        ptr.next = null;
        ptr.prev = null;

        // If head is NULL
        if (head == null) {
            head = ptr;
            first = head;
            tail = head;
        } else {
            // Else insert at beginning and change the head to current node
            ptr.next = head;
            head.prev = ptr;
            head = ptr;
        }
        i++;
    }

    // Function to insert Node at end
    static void insertAtEnd(int k) {
        // Allocating memory to the Node ptr
        Node ptr = new Node();

        // Assign Key to value k
        ptr.key = k;

        // Next and prev pointer to NULL
        ptr.next = null;
        ptr.prev = null;

        // If head is NULL
        if (head == null) {
            head = ptr;
            first = head;
            tail = head;
        } else {
            // Else insert at the end
            ptr.prev = tail;
            tail.next = ptr;
            tail = ptr;
        }
        i++;
    }

    // Function to insert Node at any position pos
    static void insertAtPos(int k, int pos) {
        // For Invalid Position
        if (pos < 1 || pos > i + 1) {
            System.out.println("Please enter a valid position");
        } else if (pos == 1) {
            // If position is at the front, then call insertAtBegin()
            insertAtBegin(k);
        } else if (pos == i + 1) {
            // Position is at length of Linked list + 1, then insert at the end
            insertAtEnd(k);
        } else {
            // Else traverse till position pos and insert the Node
            Node src = head;
            for (int j = 1; j < pos; j++) {
                src = src.next;
            }
            Node ptr = new Node();
            ptr.key = k;
            ptr.next = src;
            ptr.prev = src.prev;
            src.prev.next = ptr;
            src.prev = ptr;
            i++;
        }
    }

    // Function to delete node at the beginning of the list
    static void delAtBegin() {
        if (head != null) {
            // Move head to next and decrease length by 1
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            i--;
        }
    }

    // Function to delete at the end of the list
    static void delAtEnd() {
        if (tail != null) {
            // Move tail to the prev and decrease length by 1
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
            i--;
        }
    }

    // Function to delete the node at a given position pos
    static void delAtPos(int pos) {
        // If invalid position
        if (pos < 1 || pos > i) {
            System.out.println("Please enter a valid position");
        } else if (pos == 1) {
            // If position is 1, then call delAtBegin()
            delAtBegin();
        } else if (pos == i) {
            // If position is at the end, then call delAtEnd()
            delAtEnd();
        } else {
            // Else traverse till pos, and delete the node at pos
            Node src = head;
            for (int j = 1; j < pos; j++) {
                src = src.next;
            }
            src.prev.next = src.next;
            src.next.prev = src.prev;
            i--;
        }
    }

    public static void main(String args[]) {
        // Adding node to the linked List
        addNode(2);
        addNode(4);
        addNode(9);
        addNode(1);
        addNode(21);
        addNode(22);

        // To print the linked List
        System.out.print("Linked List: ");
        traverse();

        // To insert node at the beginning
        insertAtBegin(1);
        System.out.print("Linked List after inserting 1 at beginning: ");
        traverse();

        // To insert at the end
        insertAtEnd(0);
        System.out.print("Linked List after inserting 0 at end: ");
        traverse();

        // To insert Node with value 44 after 3rd Node
        insertAtPos(44, 3);
        System.out.print("Linked List after inserting 44 after 3rd Node: ");
        traverse();

        // To delete node at the beginning
        delAtBegin();
        System.out.print("Linked List after deleting node at beginning: ");
        traverse();

        // To delete at the end
        delAtEnd();
        System.out.print("Linked List after deleting node at end: ");
        traverse();

        // To delete Node at position 5
        delAtPos(5);
        System.out.print("Linked List after deleting node at position 5: ");
        traverse();
    }
}
