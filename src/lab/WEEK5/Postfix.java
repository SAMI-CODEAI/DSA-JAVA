package lab.WEEK5;

import java.util.Stack;
import java.util.Scanner;

public class Postfix {
    // Function to evaluate a postfix expression
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        // Split the expression by spaces
        String[] tokens = exp.split("\\s+");

        // Scan all tokens one by one
        for (String token : tokens) {
            // If the token is a number, push it to stack
            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            }
            // If the token is an operator, pop two elements from stack, apply the operator, and push the result back
            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(val2 + val1);
                        break;
                    case "-":
                        stack.push(val2 - val1);
                        break;
                    case "*":
                        stack.push(val2 * val1);
                        break;
                    case "/":
                        stack.push(val2 / val1);
                        break;
                }
            }
        }
        return stack.pop();
    }

    // Utility function to check if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter the postfix expression:");
        String exp = scanner.nextLine();

        System.out.println(evaluatePostfix(exp));

        scanner.close();
    }
}
