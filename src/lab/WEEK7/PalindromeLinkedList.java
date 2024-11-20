package lab.WEEK7;

import java.util.Scanner;
import java.util.Stack;

class ListNode4 {
    int val;
    ListNode next;

    ListNode4(int x) {
        val = x;
        next = null;
    }
}

public class PalindromeLinkedList {

    public static class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;
            Stack<Integer> stack = new Stack<>();

            // Push elements from the first half of the linked list onto the stack
            while (fast != null && fast.next != null) {
                stack.push(slow.val);
                slow = slow.next;
                fast = fast.next.next;
            }

            // If the linked list has an odd number of elements, skip the middle element
            if (fast != null) {
                slow = slow.next;
            }

            // Compare the second half of the linked list with the elements in the stack
            while (slow != null) {
                int top = stack.pop();
                if (top != slow.val) {
                    return false;
                }
                slow = slow.next;
            }

            return true;
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
            boolean result = solution.isPalindrome(head);

            System.out.println("The linked list is a palindrome: " + result);

            scanner.close();
        }
    }
}
