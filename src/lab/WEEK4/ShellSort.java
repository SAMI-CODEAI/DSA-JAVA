package lab.WEEK4;

import java.util.Scanner;

class ShellSort {
    // Function to sort arr using shellSort
    int sort(int arr[]) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return 0;
    }

    // Utility function to print array of size n
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (i == n - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.println();
    }

    // Driver method
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Get the length of the array
        System.out.print("Enter the number of elements: ");
        int len = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Get the numbers separated by space
        System.out.print("Enter the numbers separated by space: ");
        String input = scanner.nextLine();

        // Split the input string by spaces
        String[] elements = input.split(" ");

        // Convert the string elements to integers
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(elements[i].trim());
        }

        ShellSort ob = new ShellSort();
        ob.sort(arr);

        printArray(arr);
    }
}
