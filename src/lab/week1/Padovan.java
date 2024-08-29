package lab.week1;
import java.util.Scanner;
public class Padovan
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("no of terms to be displayed");
        int n = sc.nextInt();
        int[] arr = new int[Math.max(n+1,3)];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3;i<n+1;i++)
        {
            arr[i] = arr[i-2] + arr[i-3];
        }
        for(int i=0;i<n+1;i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
