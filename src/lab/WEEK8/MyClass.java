package lab.WEEK8;

public class MyClass {
    public static void main(String[] args) {
        // Create a circular linked list
        CircularLinkedList list = new CircularLinkedList();

        // Insert elements into the list
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);

        // Print the list
        // Output: 1 2 3 4
        list.printList();

        // Delete an element from the list
        list.delete(2);

        // Print the updated list
        // Output: 1 3 4
        list.printList();
    }
}
