package lab;

import java.util.Scanner;
public class Pract{
    static int MAX_SIZE=100;
    static int lookup_table[] = new int[MAX_SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int pow = 1;
        int co = 0;
        do
        {
            System.out.println("pow: "+pow);
            pow <<= 1;
            System.out.println("pow<<=1"+(pow<<=1));
            System.out.println("pow>>1"+(pow>>1));
            System.out.println("table ele");

            System.out.println((n + (pow >> 1)) / pow);
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
}