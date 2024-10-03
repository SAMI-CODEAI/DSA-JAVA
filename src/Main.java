import java.math.BigDecimal;
import java.util.*;

public class Main
{
    public static void meanum(int n,int[] array)
    {
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=array[i];
        }
        float mean=(float)sum/n;
        if(sum%n==0)
        {
            System.out.printf("%.1f",mean);
        } else if (BigDecimal.valueOf(mean).scale() > 1)
        {
            System.out.printf("%.2f",mean);
        }
        else
        {
            System.out.printf("%.1f",mean);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        Main obj=new Main();
        obj.meanum(n,array);
    }
}