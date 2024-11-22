package lab.WEEK7;

import java.util.Scanner;


public class MiddleoftheLinkedList {

    public static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
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
            ListNode middle = solution.middleNode(head);

            System.out.println("The middle of the linked list is:");
            printList(middle);

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
