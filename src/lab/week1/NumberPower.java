package lab.week1;
import java.util.Scanner;
import java.lang.Math;
public class NumberPower
{
    public static long powerOfReverse(int n)
    {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;

    }
        return (Math.pow(double n,double rev))


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = sc.nextInt();
    }
}
