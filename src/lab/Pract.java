package lab;
import java.util.Scanner;
public class Pract {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Calculate the reverse of the number
        int reversedNumber = reverseNumber(number);

        // Compute the value of the number raised to its reversed value
        long result = (long) Math.pow(number, reversedNumber);

        // Display the result
        System.out.println(number + " raised to the power of its reverse " + reversedNumber + " is: " + result);

        // Close the scanner
        scanner.close();
    }

    // Method to reverse the digits of a number
    private static int reverseNumber(int number) {
        int reversed = 0;
        int originalNumber = number;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return reversed;
    }
}
