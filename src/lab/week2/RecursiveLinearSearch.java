////package lab.week2;
////import java.util.Arrays;
////import java.util.Scanner;
////public class RecursiveLinearSearch
////{
////    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////
////        System.out.println("Enter the array elements separated by commas:");
////        String input = scanner.nextLine();
////
////        // Split the input string into an array of strings
////        String[] elements = input.split(",");
////
////        // Convert the strings to integers
////        int[] array = new int[elements.length];
////        for (int i = 0; i < elements.length; i++) {
////            array[i] = Integer.parseInt(elements[i].trim());
////        }
////
////        System.out.println("The array is: " + Arrays.toString(array));
////        System.out.println("enter key:");
////        int key= scanner.nextInt();
////        int len= input.length();
////        int result= recursiveLinearSearch(array, key, len);
////        if(result == -1)
////        {
////            System.out.println("Element not found");
////        }
////        else
////        {
////            System.out.println("Element found at index: " + result);
////        }
////    }
////    public static int recursiveLinearSearch(int[] arr, int key, int len)
////    {
////        for (int i = 0; i < len; i++)
////        {
////            if(arr[i] == key)
////                return i;
////        }
////        return -1;
////    }
////}
////
////
////
////
////
//package lab.week2;
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class RecursiveLinearSearch {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the array elements separated by commas:");
//        String input = scanner.nextLine();
//
//        // Split the input string into an array of strings
//        String[] elements = input.split(",");
//
//        // Convert the strings to integers
//        int[] array = new int[elements.length];
//        for (int i = 0; i < elements.length; i++) {
//            array[i] = Integer.parseInt(elements[i].trim());
//        }
//
//        System.out.println("The array is: " + Arrays.toString(array));
//        System.out.println("Enter key:");
//        int key = scanner.nextInt();
//
//        int result = recursiveLinearSearch(array, key, 0);
//        if (result == -1) {
//            System.out.println("Element not found");
//        } else {
//            System.out.println("Element found at index: " + result);
//        }
//    }
//
//    public static int recursiveLinearSearch(int[] arr, int key, int index) {
//        if (index >= arr.length) {
//            return -1; // Base case: key not found
//        }
//        if (arr[index] == key) {
//            return index; // Base case: key found
//        }
//        return recursiveLinearSearch(arr, key, index + 1); // Recursive case
//    }
//}


package lab.week2;
import java.io.*;

import java.util.Scanner;

class RecursiveLinearSearch {
    public static int search(int arr[], int N, int x) {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Driver code
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        // Taking array elements input separated by commas
        System.out.print("Enter the elements of the array separated by commas: ");
        String input = scanner.nextLine();
        String[] inputArray = input.split(",");
        int N = inputArray.length;
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputArray[i].trim());
        }

        // Taking the element to search for input
        System.out.print("Enter the element to search for: ");
        int x = scanner.nextInt();

        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1)
            System.out.print("Element is not present in array");
        else
            System.out.print("Element is present at index " + result);

        scanner.close();
    }
}

