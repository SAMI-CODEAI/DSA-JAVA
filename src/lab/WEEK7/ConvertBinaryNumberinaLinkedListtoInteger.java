package lab.WEEK7;

import java.util.Scanner;

public class ConvertBinaryNumberinaLinkedListtoInteger {

    public static class Solution {
        public int getDecimalValue(ListNode head) {
            int result = 0;
            while (head != null) {
                result = result * 2 + head.val;
                head = head.next;
            }
            return result;
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
            int decimalValue = solution.getDecimalValue(head);

            System.out.println("The decimal value of the binary number is: " + decimalValue);

            scanner.close();
        }
    }
}
