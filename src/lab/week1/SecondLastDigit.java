package lab.week1;

import java.util.Scanner;
public class SecondLastDigit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int inp = sc.nextInt();
        int n=Math.abs(inp);
        System.out.println(sl(n));
    }
    public static int sl(int n)
    {
        if(n<10)
        {
            return -1;
        }
        else
        {
            return (n/10)%10;
        }
    }
}
