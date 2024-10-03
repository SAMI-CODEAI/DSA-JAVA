package lab.WEEK5;

import java.util.Stack;
import java.util.Scanner;

public class ReverseStack {

    // Function to push element to stack
    public static void push(Stack<Integer> stack, int x) {
        stack.push(x);
    }

    // Function to pop element from stack
    public static int pop(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return -1; // Indicating stack is empty
    }

    // Function to check if stack is empty
    public static boolean isEmpty(Stack<Integer> stack) {
        return stack.isEmpty();
    }

    // Function to display the elements of the stack
    public static void show(Stack<Integer> stack) {
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
            if (i < stack.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Recursive function to insert an element at the bottom of the stack
    public static void BottomInsertion(Stack<Integer> stack, int x) {
        if (isEmpty(stack)) {
            push(stack, x);
        } else {
            int temp = pop(stack);
            BottomInsertion(stack, x);
            push(stack, temp);
        }
    }

    // Recursive function to reverse the stack
    public static void Reverse(Stack<Integer> stack) {
        if (!isEmpty(stack)) {
            int temp = pop(stack);
            Reverse(stack);
            BottomInsertion(stack, temp);
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter the elements separated by space:");
        String[] elements = scanner.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String element : elements) {
            push(stack, Integer.parseInt(element));
        }

        // System.out.println("Original stack:");
        // show(stack);

        Reverse(stack);

        // System.out.println("Reversed stack:");
        show(stack);

        scanner.close();
    }
}

