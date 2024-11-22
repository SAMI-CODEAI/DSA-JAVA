package lab.WEEK8;

// Class CircularNode
class CircularNode {
    int data;
    CircularNode next;

    // Constructor to initialize a node with data
    public CircularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

// Class CircularLinkedList
public class CircularLinkedList {
    private CircularNode head;
    private CircularNode tail;

    // Constructor CircularLinkedList
    public CircularLinkedList() {
        head = null;
        tail = null;
    }

    // Method to insert a new node with the given data into the circular linked list
    public void insert(int data) {
        CircularNode newNode = new CircularNode(data);

        // If the list is empty, make the new node the head and tail
        if (head == null) {
            head = newNode;
            tail = newNode;
            // Point to itself in a circular list
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to delete the node with the given key from the circular linked list
    public void delete(int key) {
        if (head == null) {
            return;
        }

        CircularNode curr = head;
        CircularNode prev = null;

        while (curr.next != head) {
            if (curr.data == key) {
                // If the node to be deleted is the head node
                if (prev == null) {
                    CircularNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = curr.next;
                    last.next = head;
                    return;
                } else {
                    prev.next = curr.next;
                    // Update tail if the last node is deleted
                    if (curr == tail) {
                        tail = prev;
                    }
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        // Check if the node to be deleted is the last node
        if (curr == head && curr.data == key) {
            prev.next = head;
            // Update tail if the last node is deleted
            tail = prev;
        }
    }

    // Method to display the elements of the circular linked list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Linked List Elements: ");

        CircularNode itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.next;
        } while (itr != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        list.printList();  // Output: Linked List Elements: 1 2 3 4

        list.delete(3);
        list.printList();  // Output: Linked List Elements: 1 2 4

        list.delete(1);
        list.printList();  // Output: Linked List Elements: 2 4
    }
}
