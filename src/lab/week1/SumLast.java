package lab.week1;

import java.util.Scanner;
public class SumLast
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int a = sc.nextInt();
        System.out.println("Enter the second number: ");
        int b = sc.nextInt();
        int x=Math.abs(a)%10;
        int y=Math.abs(b)%10;
        int sum=x+y;
        System.out.println(sum);
    }
}
