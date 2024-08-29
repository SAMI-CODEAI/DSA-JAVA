package lab.week1;

import java.util.Scanner;
public class CombineStr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        System.out.println(combineStrings(a, b));
    }

    public static String combineStrings(String a, String b)
    {
        if (a.length() <= b.length())
        {
            return a + b + a;
        }
        else
        {
            return b + a + b;
        }
    }
}