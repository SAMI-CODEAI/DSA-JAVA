package lab.week1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayLeaders {
    public static List<Integer> findArrayLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int size = arr.length;

        int maxFromRight = arr[size - 1];
        leaders.add(maxFromRight);

        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }

        return leaders;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> result = findArrayLeaders(arr);

        System.out.print("Leaders in the array: ");
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + " ");
        }
    }
}

