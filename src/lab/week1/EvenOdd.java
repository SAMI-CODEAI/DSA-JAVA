package lab.week1;

import java.util.Scanner;

public class EvenOdd {
    public static int countNumbers(int[] numbers, String type) {
        int count = 0;
        if (type.equals("even")) {
            for (int num : numbers) {
                if (num % 2 == 0) count++;
            }
        } else if (type.equals("odd")) {
            for (int num : numbers) {
                if (num % 2 != 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Declare the Scanner object
        int[] array = new int[5];
//        System.out.println("Enter the elements of the array: ");
        for(int i=0; i<5; i++)
        {
            System.out.println("Enter number " + (i+1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.println("even or odd");
        String type =sc.next();
        System.out.println("Number of " + type + " numbers: " + countNumbers(array, type));
    }
}