package lab.WEEK9;

import java.util.LinkedList;
import java.util.Queue;

// Node Class for all traversal types
class Node2 {
    int data;
    Node2 left, right;

    public Node2(int item) {
        data = item;
        left = right = null;
    }
}

// Main class to include all traversal techniques
public class BinaryTreeTraversalTechniques {

    // Function to perform inorder traversal
    static void inorderTraversal(Node2 node2) {
        // Base case
        if (node2 == null)
            return;

        // Recur on the left subtree
        inorderTraversal(node2.left);

        // Visit the current node
        System.out.print(node2.data + " ");

        // Recur on the right subtree
        inorderTraversal(node2.right);
    }

    // Function to perform preorder traversal
    static void preorderTraversal(Node2 node2) {
        // Base case
        if (node2 == null)
            return;

        // Visit the current node
        System.out.print(node2.data + " ");

        // Recur on the left subtree
        preorderTraversal(node2.left);

        // Recur on the right subtree
        preorderTraversal(node2.right);
    }

    // Function to perform postorder traversal
    static void postorderTraversal(Node2 node2) {
        // Base case
        if (node2 == null)
            return;

        // Recur on the left subtree
        postorderTraversal(node2.left);

        // Recur on the right subtree
        postorderTraversal(node2.right);

        // Visit the current node
        System.out.print(node2.data + " ");
    }

    // Function to perform level order traversal
    static void levelOrderTraversal(Node2 root) {
        if (root == null)
            return;

        Queue<Node2> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node2 curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);
        root.right.right = new Node2(6);

        System.out.println("Inorder traversal:");
        inorderTraversal(root);
        System.out.println("\nPreorder traversal:");
        preorderTraversal(root);
        System.out.println("\nPostorder traversal:");
        postorderTraversal(root);
        System.out.println("\nLevel order traversal:");
        levelOrderTraversal(root);
    }
}
