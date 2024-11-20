import java.util.Scanner;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Insert at end
    public void insertAtEnd(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Update a node
    public void updateNode(String val, int index) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == index) {
                temp.data = val;
                return;
            }
            count++;
            temp = temp.next;
        }
    }

    // Remove first node
    public void remove_first_node() {
        if (head != null) {
            head = head.next;
        }
    }

    // Remove last node
    public void remove_last_node() {
        if (head == null || head.next == null) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    // Remove at index
    public void remove_at_index(int index) {
        if (head == null) return;

        Node temp = head;

        if (index == 0) {
            head = temp.next;
            return;
        }

        for (int i = 0; temp != null && i < index - 1; i++)
            temp = temp.next;

        if (temp == null || temp.next == null)
            return;

        Node next = temp.next.next;
        temp.next = next;
    }

    // Remove node by value
    public void remove_node(String data) {
        Node temp = head, prev = null;

        if (temp != null && temp.data.equals(data)) {
            head = temp.next;
            return;
        }

        while (temp != null && !temp.data.equals(data)) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
    }

    // Get size of linked list
    public int sizeOfLL() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Print linked list
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Insert at end");
            System.out.println("2. Update a node");
            System.out.println("3. Remove first node");
            System.out.println("4. Remove last node");
            System.out.println("5. Remove node by index");
            System.out.println("6. Remove node by value");
            System.out.println("7. Get size of linked list");
            System.out.println("8. Print linked list");
            System.out.println("9. Exit");

            choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    System.out.print("Enter data to insert: ");
                    String data = scanner.nextLine();
                    list.insertAtEnd(data);
                    break;
                case "2":
                    System.out.print("Enter new value: ");
                    String val = scanner.nextLine();
                    System.out.print("Enter index to update: ");
                    int idx = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    list.updateNode(val, idx);
                    break;
                case "3":
                    list.remove_first_node();
                    break;
                case "4":
                    list.remove_last_node();
                    break;
                case "5":
                    System.out.print("Enter index to remove: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    list.remove_at_index(index);
                    break;
                case "6":
                    System.out.print("Enter value to remove: ");
                    String value = scanner.nextLine();
                    list.remove_node(value);
                    break;
                case "7":
                    System.out.println("Size of linked list: " + list.sizeOfLL());
                    break;
                case "8":
                    list.printLL();
                    break;
                case "9":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("9"));

        scanner.close();
    }
}
