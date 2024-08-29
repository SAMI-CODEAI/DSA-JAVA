package lab.week1;

import java.util.Scanner;
import java.util.ArrayList;

public class ArrayLeaders {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Initialize the array
        int[] array = new int[n];

        // Prompt user to enter the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Find leaders in the array
        ArrayList<Integer> leaders = findLeaders(array);

        // Print the leaders
        System.out.println("Leaders in the array:");
        for (int leader : leaders) {
            System.out.print(leader + " ");
        }
        System.out.println();

        // Close the scanner
        scanner.close();
    }

    // Method to find leaders in the array
    private static ArrayList<Integer> findLeaders(int[] array) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int n = array.length;

        if (n == 0) {
            return leaders;
        }

        // Initialize the maximum element from the right
        int maxFromRight = array[n - 1];
        leaders.add(maxFromRight);

        // Traverse the array from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (array[i] > maxFromRight) {
                maxFromRight = array[i];
                leaders.add(maxFromRight);
            }
        }

        // Reverse the list to maintain the original order of leaders
        java.util.Collections.reverse(leaders);

        return leaders;
    }
}

