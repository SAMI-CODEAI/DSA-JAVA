package lab.week1;
import java.util.Arrays;
import java.util.Scanner;
public class ArrayMean
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the array elements separated by space:");
        String input = scanner.nextLine();

        // Split the input string into an array of strings
        String[] elements = input.split(" ");

        // Convert the array of strings to an array of integers
        int[] numbers = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            numbers[i] = Integer.parseInt(elements[i].trim());
        }

//        System.out.println("The array is: " + Arrays.toString(numbers));
        System.out.println(Mean(numbers));
    }
    public static double Mean(int[] numbers)
    {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            sum += numbers[i];
        }
        double average = sum / numbers.length;
        return average;
    }

}
