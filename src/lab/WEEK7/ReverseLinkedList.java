package lab.WEEK7;

import java.util.Scanner;


public class ReverseLinkedList {

    public static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            while (current != null) {
                ListNode nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            return prev;
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

            Solution solution = new Solution();
            head = solution.reverseList(head);

            System.out.println("Reversed linked list:");
            printList(head);

            scanner.close();
        }

        public static void printList(ListNode head) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.val + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}
