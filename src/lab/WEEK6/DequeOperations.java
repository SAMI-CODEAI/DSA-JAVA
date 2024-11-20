package lab.WEEK6;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DequeOperations {
    private Deque<Integer> deque;

    public DequeOperations() {
        deque = new ArrayDeque<>();
    }

    // Append an element to the right end of the deque
    public void append(int value) {
        deque.addLast(value);
    }

    // Append an element to the left end of the deque
    public void appendLeft(int value) {
        deque.addFirst(value);
    }

    // Pop an element from the right end of the deque
    public Integer pop() {
        return deque.pollLast();
    }

    // Pop an element from the left end of the deque
    public Integer popLeft() {
        return deque.pollFirst();
    }

    // Get the index of the first occurrence of an element
    public int index(int value) {
        int index = 0;
        for (Integer element : deque) {
            if (element == value) {
                return index;
            }
            index++;
        }
        return -1; // Element not found
    }

    // Insert an element at a specific index
    public void insert(int index, int value) {
        if (index < 0 || index > deque.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Deque<Integer> tempDeque = new ArrayDeque<>();
        int currentIndex = 0;

        // Copy elements to a temporary deque until the index
        for (Integer element : deque) {
            if (currentIndex == index) {
                tempDeque.add(value); // Insert the new value
            }
            tempDeque.add(element);
            currentIndex++;
        }

        // If the index is equal to the size, add the value at the end
        if (currentIndex == index) {
            tempDeque.add(value);
        }

        deque = tempDeque; // Update the original deque
    }

    // Remove the first occurrence of a value
    public void remove(int value) {
        deque.remove(value);
    }

    // Count occurrences of a value
    public int count(int value) {
        int count = 0;
        for (Integer element : deque) {
            if (element == value) {
                count++;
            }
        }
        return count;
    }

    // Get the size of the deque
    public int size() {
        return deque.size();
    }

    // Access the front element
    public Integer getFront() {
        return deque.peekFirst();
    }

    // Access the back element
    public Integer getBack() {
        return deque.peekLast();
    }

    // Extend the deque by adding multiple values at the right end
    public void extend(Integer[] values) {
        for (Integer value : values) {
            append(value);
        }
    }

    // Extend the deque by adding multiple values at the left end
    public void extendLeft(Integer[] values) {
        for (int i = values.length - 1; i >= 0; i--) {
            appendLeft(values[i]);
        }
    }

    // Reverse the order of deque elements
    public void reverse() {
        Deque<Integer> reversedDeque = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            reversedDeque.addFirst(deque.pollFirst());
        }
        deque = reversedDeque;
    }

    // Rotate the deque
    public void rotate(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                Integer value = pop();
                if (value != null) {
                    append(value);
                }
            }
        } else {
            for (int i = 0; i < -n; i++) {
                Integer value = popLeft();
                if (value != null) {
                    appendLeft(value);
                }
            }
        }
    }

    // Print the deque for demonstration
    public void printDeque() {
        System.out.println(deque);
    }

    public static void main(String[] args) {
        DequeOperations dequeOps = new DequeOperations();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Deque Operations:");
        System.out.println("Commands: append <value>, appendLeft <value>, pop, popLeft, index <value>, insert <index> <value>, remove <value>, count <value>, size, getFront, getBack, extend <value1,value2,...>, extendLeft <value1,value2,...>, reverse, rotate <n>, print, exit");

        while (true) {
            System.out.print("Enter commands (separated by commas): ");
            String input = scanner.nextLine().trim();
            String[] commands = input.split(",");

            for (String command : commands) {
                String[] parts = command.trim().split(" ");
                String action = parts[0];

                switch (action) {
                    case "append":
                        if (parts.length == 2) {
                            int value = Integer.parseInt(parts[1]);
                            dequeOps.append(value);
                        }
                        break;

                    case "appendLeft":
                        if (parts.length == 2) {
                            int value = Integer.parseInt(parts[1]);
                            dequeOps.appendLeft(value);
                        }
                        break;

                    case "pop":
                        Integer poppedValue = dequeOps.pop();
                        System.out.println("Popped from right: " + poppedValue);
                        break;

                    case "popLeft":
                        Integer poppedLeftValue = dequeOps.popLeft();
                        System.out.println("Popped from left: " + poppedLeftValue);
                        break;

                    case "index":
                        if (parts.length == 2) {
                            int indexValue = Integer.parseInt(parts[1]);
                            int index = dequeOps.index(indexValue);
                            System.out.println("Index of " + indexValue + ": " + index);
                        }
                        break;

                    case "insert":
                        if (parts.length == 3) {
                            int index = Integer.parseInt(parts[1]);
                            int valueToInsert = Integer.parseInt(parts[2]);
                            dequeOps.insert(index, valueToInsert);
                        }
                        break;

                    case "remove":
                        if (parts.length == 2) {
                            int valueToRemove = Integer.parseInt(parts[1]);
                            dequeOps.remove(valueToRemove);
                        }
                        break;

                    case "count":
                        if (parts.length == 2) {
                            int countValue = Integer.parseInt(parts[1]);
                            int count = dequeOps.count(countValue);
                            System.out.println("Count of " + countValue + ": " + count);
                        }
                        break;

                    case "size":
                        System.out.println("Size of deque: " + dequeOps.size());
                        break;

                    case "getFront":
                        Integer front = dequeOps.getFront();
                        System.out.println("Front element: " + front);
                        break;

                    case "getBack":
                        Integer back = dequeOps.getBack();
                        System.out.println("Back element: " + back);
                        break;

                    case "extend":
                        if (parts.length == 2) {
                            String[] values = parts[1].split(",");
                            Integer[] intValues = new Integer[values.length];
                            for (int i = 0; i < values.length; i++) {
                                intValues[i] = Integer.parseInt(values[i].trim());
                            }
                            dequeOps.extend(intValues);
                        }
                        break;

                    case "extendLeft":
                        if (parts.length == 2) {
                            String[] values = parts[1].split(",");
                            Integer[] intValues = new Integer[values.length];
                            for (int i = 0; i < values.length; i++) {
                                intValues[i] = Integer.parseInt(values[i].trim());
                            }
                            dequeOps.extendLeft(intValues);
                        }
                        break;

                    case "reverse":
                        dequeOps.reverse();
                        System.out.println("Deque reversed.");
                        break;

                    case "rotate":
                        if (parts.length == 2) {
                            int n = Integer.parseInt(parts[1]);
                            dequeOps.rotate(n);
                            System.out.println("Deque rotated by " + n);
                        }
                        break;

                    case "print":
                        dequeOps.printDeque();
                        break;

                    case "exit":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Unknown command: " + action);
                }
            }
        }
    }}