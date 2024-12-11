package lab.WEEK10;

public class SecondLargestElementinBST {
}

// Java program to find the second largest element in BST using reverse inorder traversal
class Nodeee {
    int data;
    Node left, right;

    Nodeee(int x) {
        data = x;
        left = right = null;
    }
}

class GfGgg {

    // Helper function to find the second largest element
    static void reverseInorder(Node root, int[] count, int[] result) {
        // Base case: if root is null or we have already found the second largest
        if (root == null || count[0] >= 2) {
            return;
        }

        // Traverse the right subtree first (reverse inorder)
        reverseInorder(root.right, count, result);

        // Increment the count of visited nodes
        count[0]++;

        // If count becomes 2, then this is the second largest element
        if (count[0] == 2) {
            result[0] = root.data;
            return;
        }

        // Traverse the left subtree
        reverseInorder(root.left, count, result);
    }

    // Function to find the second largest element in BST
    static int findSecondLargest(Node root) {
        int[] count = {0};
        int[] result = {-1};

        // Start reverse inorder traversal
        reverseInorder(root, count, result);

        return result[0];
    }

    public static void main(String[] args) {
        // Representation of the input BST:
        //     7
        //    / \
        //   4   8
        //  / \
        // 3   5
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);

        int secondLargest = findSecondLargest(root);

        System.out.println(secondLargest);
    }
}
