package lab.WEEK7;
import java.util.Scanner;


public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the elements of the linked list, separated by commas:");
        String input = scanner.nextLine();
        String[] values = input.split(",");

        ListNode head = null;
        ListNode tail = null;

        for (String value : values) {
            int val = Integer.parseInt(value.trim());
            ListNode newNode = new ListNode(val);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        System.out.println("Enter the position where the tail should connect to create a cycle (-1 for no cycle):");
        int pos = scanner.nextInt();

        if (pos >= 0) {
            ListNode temp = head;
            for (int i = 0; i < pos; i++) {
                temp = temp.next;
            }
            tail.next = temp;
        }

        LinkedListCycle solution = new LinkedListCycle();
        boolean result = solution.hasCycle(head);

        System.out.println("The linked list has a cycle: " + result);

        scanner.close();
    }
}
