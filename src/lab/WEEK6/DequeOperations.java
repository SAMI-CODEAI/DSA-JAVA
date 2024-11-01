package lab.WEEK6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        int choice, value, index;

        do {
            System.out.println("\nDeque Operations:");
            System.out.println("1. Append (to the right)");
            System.out.println("2. AppendLeft (to the left)");
            System.out.println("3. Pop (from the right)");
            System.out.println("4. PopLeft (from the left)");
            System.out.println("5. Display front element");
            System.out.println("6. Display rear element");
            System.out.println("7. Display all elements");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to append: ");
                    value = scanner.nextInt();
                    deque.addLast(value);
                    System.out.println(value + " appended to the right.");
                    break;
                case 2:
                    System.out.print("Enter value to append to the left: ");
                    value = scanner.nextInt();
                    deque.addFirst(value);
                    System.out.println(value + " appended to the left.");
                    break;
                case 3:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println(deque.removeLast() + " popped from the right.");
                    }
                    break;
                case 4:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println(deque.removeFirst() + " popped from the left.");
                    }
                    break;
                case 5:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Front element: " + deque.getFirst());
                    }
                    break;
                case 6:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Rear element: " + deque.getLast());
                    }
                    break;
                case 7:
                    if (deque.isEmpty()) {
                        System.out.println("Deque is empty");
                    } else {
                        System.out.println("Deque elements: " + deque);
                    }
                    break;
                case 8:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}
