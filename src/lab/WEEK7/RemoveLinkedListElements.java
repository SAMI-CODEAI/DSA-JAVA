package lab.WEEK7;

import java.util.Scanner;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
        next = null;
    }
}

public class RemoveLinkedListElements {
    public ListNode1 removeElements(ListNode1 head, int val) {
        // Create a dummy node to handle edge cases smoothly
        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;

        ListNode1 current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the linked list, separated by commas:");
        String input = scanner.nextLine();
        String[] values = input.split(",");

        ListNode1 head = null;
        ListNode1 tail = null;

        for (String value : values) {
            int val = Integer.parseInt(value.trim());
            ListNode1 newNode = new ListNode1(val);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        System.out.println("Enter the value to remove:");
        int valueToRemove = scanner.nextInt();

        RemoveLinkedListElements solution = new RemoveLinkedListElements();
        head = solution.removeElements(head, valueToRemove);

        System.out.println("Updated linked list:");
        printList(head);

        scanner.close();
    }

    public static void printList(ListNode1 head) {
        ListNode1 current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
