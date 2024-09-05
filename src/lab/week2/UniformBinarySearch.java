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
        String[] elements = input.split(", ");

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
//Sure! Let's dive into the `create_table` method and understand how the lookup table is created.
//
//        ### Purpose
//The `create_table` method precomputes indices for the uniform binary search and stores them in the `lookup_table` array. This helps in efficiently narrowing down the search space during the binary search.
//
//### Parameters
//- **`n`**: The size of the array for which the lookup table is being created.
//
//### Variables
//- **`pow`**: This variable is used to calculate powers of 2. It starts at 1 and is doubled in each iteration.
//        - **`co`**: This is a counter used to keep track of the current index in the `lookup_table`.
//
//        ### Logic
//1. **Initialization**:
//        - `pow` is initialized to 1.
//        - `co` is initialized to 0.
//
//        2. **Loop**:
//        - The loop continues until a 0 is added to the `lookup_table`.
//        - Inside the loop:
//        - `pow` is doubled using the left shift operator (`pow <<= 1`).
//        - The current index in the `lookup_table` is calculated as:
//        ```java
//lookup_table[co] = (n + (pow >> 1)) / pow;
//       ```
//This formula ensures that the indices are evenly distributed for the binary search.
//     - The counter `co` is incremented.
//
//        3. **Termination**:
//        - The loop terminates when a 0 is added to the `lookup_table`.
//
//        ### Example
//Let's say `n = 10`:
//
//        - **First Iteration**:
//        - `pow` becomes 2.
//        - `lookup_table[0] = (10 + 1) / 2 = 5`.
//
//        - **Second Iteration**:
//        - `pow` becomes 4.
//        - `lookup_table[1] = (10 + 2) / 4 = 3`.
//
//        - **Third Iteration**:
//        - `pow` becomes 8.
//        - `lookup_table[2] = (10 + 4) / 8 = 1`.
//
//        - **Fourth Iteration**:
//        - `pow` becomes 16.
//        - `lookup_table[3] = (10 + 8) / 16 = 1`.
//
//        - **Fifth Iteration**:
//        - `pow` becomes 32.
//        - `lookup_table[4] = (10 + 16) / 32 = 0`.
//
//The loop stops here because `lookup_table[4]` is 0.
//
//        ### Summary
//The `create_table` method efficiently precomputes indices for the uniform binary search, ensuring that the search process is optimized. The precomputed indices help in quickly narrowing down the search space.
//
//Feel free to ask if you have any more questions or need further clarification!