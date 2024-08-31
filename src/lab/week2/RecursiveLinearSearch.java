package lab.week2;
import java.util.Arrays;
import java.util.Scanner;
public class RecursiveLinearSearch
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the array elements separated by commas:");
        String input = scanner.nextLine();

        // Split the input string into an array of strings
        String[] elements = input.split(",");

        // Convert the strings to integers
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i].trim());
        }

        System.out.println("The array is: " + Arrays.toString(array));
        System.out.println("enter key:");
        int key= scanner.nextInt();
        int len= input.length();
        int result= recursiveLinearSearch(array, key, len);
        if(result == -1)
        {
            System.out.println("Element not found");
        }
        else
        {
            System.out.println("Element found at index: " + result);
        }
    }
    public static int recursiveLinearSearch(int[] arr, int key, int len)
    {
        for (int i = 0; i < len; i++)
        {
            if(arr[i] == key)
                return i;
        }
        return -1;
    }
}
