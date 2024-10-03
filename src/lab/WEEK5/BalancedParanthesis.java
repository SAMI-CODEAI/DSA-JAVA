package lab.WEEK5;
import java.util.Stack;
import java.util.Scanner;

public class BalancedParanthesis {
    // Function to check if parentheses are balanced
    public static boolean areParenthesesBalanced(String expr) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the expression
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // If the current character is an opening bracket, push it onto the stack
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            // If the current character is a closing bracket, check for matching opening bracket
            else if (c == '}' || c == ']' || c == ')') {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return false;
                }
            }
        }

        // If stack is empty, all opening brackets have matching closing brackets
        return stack.isEmpty();
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // System.out.println("Enter an expression:");
        String expr = scanner.nextLine();

        boolean result = areParenthesesBalanced(expr);

        System.out.println(result);

        scanner.close();
    }
}
