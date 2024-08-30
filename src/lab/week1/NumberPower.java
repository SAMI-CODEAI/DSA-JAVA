package lab.week1;
import java.util.Scanner;
import java.lang.Math;

public class NumberPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int rev = Reverse(num);
        System.out.println(num);
        System.out.println(rev);
        long result = (long) Math.pow(num, rev);
        System.out.println("Result: " + result);
    }

    public static int Reverse(int no) {
        int rev = 0;
        int n = no;
        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev;
    }
}
