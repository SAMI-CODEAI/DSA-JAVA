package lab.week1;

import java.util.Scanner;
public class Multiple
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();
        System.out.println(Mul(a,b));

    }
    public static int Mul(int a,int b)
    {
        if(a==0||b==0)
        {
//            System.out.println("3");
            return 3;
        }
        else
        {
            if(a%b==0)
            {
//                System.out.println("2");
                return 2;
            }
            else
            {
//                System.out.println("1");
                return 1;
            }
        }
    }
}
