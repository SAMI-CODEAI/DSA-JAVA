package lab.week2;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
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
        int n=array.length;
        System.out.println("The array is: " + Arrays.toString(array));
        System.out.println("Enter the element to be searched:");
        int key = scanner.nextInt();
        int result=binarySearch(array,0,n-1,key);
        System.out.println("the element is found at index:"+result);
    }
    public static int binarySearch(int arr[], int l, int r, int x)
    {
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
            {
                return mid;
            }
            else if (arr[mid] > x)
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return -1;
    }
}




