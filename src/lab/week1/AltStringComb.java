package lab.week1;
import java.util.Scanner;
public class AltStringComb
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter 1 string");
        String s1 = sc.nextLine();
        System.out.println("enter 2 string");
        String s2 = sc.nextLine();
        StringBuilder comb = new StringBuilder();
        int l1=s1.length();
        int l2=s2.length();
        int maxl=Math.max(l1,l2);
        for (int i=0;i<maxl;i++)
        {
            if(i<l1)
            {
             comb.append(s1.charAt(i));
            }
            if(i<l2)
            {
                comb.append(s2.charAt(i));
            }
        }
        System.out.println(comb.toString());
    }
}
