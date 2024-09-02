package lab.week2;
import java.util.Scanner;

public class UniformBinarySearch
{
    static int MAX_SIZE = 1000;
    static int lookup_table[] = new int[MAX_SIZE];

    static void create_table(int n)
    {
        int pow = 1;
        int co = 0;
        do
        {
            pow <<= 1;
            lookup_table[co] = (n + (pow >> 1)) / pow;
        }
        while (lookup_table[co++] != 0);

        // Print the lookup table
        System.out.println("Lookup Table:");
        for (int i = 0; i < co; i++) {
            System.out.print(lookup_table[i] + " ");
        }
        System.out.println();
    }

    static int binary(int arr[], int v)
    {
        int index = lookup_table[0] - 1;
        int co = 0;
        while (lookup_table[co] != 0)
        {
            if (v == arr[index])
                return index;
            else if (v < arr[index])
            {
                index -= lookup_table[++co];
            }
            else
            {
                index += lookup_table[++co];
            }
        }
        return index;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements separated by commas:");
        String input = sc.nextLine();

        // Split the input string into an array of strings
        String[] elements = input.split(",");

        // Convert the strings to integers
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            arr[i] = Integer.parseInt(elements[i].trim());
        }
        int n = arr.length;
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        create_table(n);
        System.out.println("Position of " + key + " in array = " + binary(arr, key));
    }
}
