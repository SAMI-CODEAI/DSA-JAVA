// Java program to add elements to a LinkedList
import java.util.LinkedList;

public class Main {

    // Main driver method
    public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Adding elements to the LinkedList using add() method
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(3,4);
        // Printing the LinkedList
        System.out.println(list);
    }
}
