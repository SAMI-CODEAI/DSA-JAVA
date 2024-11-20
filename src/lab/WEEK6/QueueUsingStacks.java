package lab.WEEK6;

import java.util.Scanner;
import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from the front of the queue and returns that element. */
    public int pop() {
        if (empty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter commands separated by commas (e.g., push 1, pop, peek, empty, exit):");
        String input = scanner.nextLine();
        String[] commands = input.split(",");

        for (String command : commands) {
            String[] parts = command.trim().split(" ");
            switch (parts[0].toLowerCase()) {
                case "push":
                    if (parts.length > 1) {
                        try {
                            int value = Integer.parseInt(parts[1]);
                            queue.push(value);
                            System.out.println(value + " pushed to queue.");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid value. Please enter a valid integer.");
                        }
                    } else {
                        System.out.println("Please provide a value to push.");
                    }
                    break;
                case "pop":
                    int poppedValue = queue.pop();
                    if (poppedValue != -1) {
                        System.out.println("Popped: " + poppedValue);
                    }
                    break;
                case "peek":
                    int frontValue = queue.peek();
                    if (frontValue != -1) {
                        System.out.println("Front: " + frontValue);
                    }
                    break;
                case "empty":
                    System.out.println("Is queue empty? " + queue.empty());
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid command: " + command);
            }
        }

        scanner.close();
    }
}
