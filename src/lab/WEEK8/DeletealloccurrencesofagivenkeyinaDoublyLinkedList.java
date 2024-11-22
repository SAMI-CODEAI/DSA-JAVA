package lab.WEEK8;
/* Java implementation to delete all occurrences
   of a given key in a doubly linked list */

// A node of the doubly linked list
class DoublyNode {
    int data;
    DoublyNode next, prev;
}

class GFG2 {
    /* Function to delete a node in a Doubly Linked List.
       head_ref --> pointer to head node pointer.
       del --> pointer to node to be deleted. */
    static DoublyNode deleteNode(DoublyNode head, DoublyNode del) {
        // Base case
        if (head == null || del == null) return null;

        // If node to be deleted is head node
        if (head == del) head = del.next;

        // Change next only if node to be deleted is NOT the last node
        if (del.next != null) del.next.prev = del.prev;

        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null) del.prev.next = del.next;

        del = null;
        return head;
    }

    /* Function to delete all occurrences of the given key 'x' */
    static DoublyNode deleteAllOccurOfX(DoublyNode head, int x) {
        // If list is empty
        if (head == null) return null;

        DoublyNode current = head;
        DoublyNode next;

        // Traverse the list up to the end
        while (current != null) {
            // If node found with the value 'x'
            if (current.data == x) {
                // Save current's next node in the pointer 'next'
                next = current.next;

                // Delete the node pointed to by 'current'
                head = deleteNode(head, current);

                // Update current
                current = next;
            } else {
                // Simply move to the next node
                current = current.next;
            }
        }

        return head;
    }

    /* Function to insert a node at the beginning of the Doubly Linked List */
    static DoublyNode push(DoublyNode head, int new_data) {
        // Allocate node
        DoublyNode new_node = new DoublyNode();

        // Put in the data
        new_node.data = new_data;

        // Since we are adding at the beginning, prev is always NULL
        new_node.prev = null;

        // Link the old list to the new node
        new_node.next = head;

        // Change prev of head node to new node
        if (head != null) head.prev = new_node;

        // Move the head to point to the new node
        head = new_node;

        return head;
    }

    /* Function to print nodes in a given doubly linked list */
    static void printList(DoublyNode temp) {
        if (temp == null) {
            System.out.print("Doubly Linked list empty");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // Driver code
    public static void main(String args[]) {
        // Start with the empty list
        DoublyNode head = null;

        /* Create the doubly linked list: 2<->2<->10<->8<->4<->2<->5<->2 */
        head = push(head, 2);
        head = push(head, 5);
        head = push(head, 2);
        head = push(head, 4);
        head = push(head, 8);
        head = push(head, 10);
        head = push(head, 2);
        head = push(head, 2);

        System.out.println("Original Doubly linked list: ");
        printList(head);

        int x = 2;

        // Delete all occurrences of 'x'
        head = deleteAllOccurOfX(head, x);

        System.out.println("\nDoubly linked list after deletion of " + x + ":");
        printList(head);
    }
}
