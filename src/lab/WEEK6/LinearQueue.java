package lab.WEEK6;

import java.util.Scanner;

public class LinearQueue {
    private static final int MAX = 10;
    private static int[] queue = new int[MAX];
    private static int front = -1;
    private static int rear = -1;

    // Check if the queue is empty
    public static boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    public static boolean isFull() {
        return rear == MAX - 1;
    }

    // Enqueue operation
    public static void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front = 0;
        }
        queue[++rear] = item;
        System.out.println(item + " enqueued to the queue");
    }

    // Dequeue operation
    public static void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(queue[front] + " dequeued from the queue");
        if (front >= rear) {
            front = rear = -1;
        } else {
            front++;
        }
    }

    // Display the queue
    public static void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice, value;
        do {
            System.out.println("\nQueue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    value = scanner.nextInt();
                    enqueue(value);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
}
