package lab.WEEK9;

import java.util.LinkedList;
import java.util.Queue;

public class InsertioninaBinaryTreeinLevelOrder {

    public static void main(String[] args) {
        // Constructing the binary tree
        //     10
        //    /  \
        //   11   9
        //  /    / \
        // 7    15  8
        Node3 root = new Node3(10);
        root.left = new Node3(11);
        root.right = new Node3(9);
        root.left.left = new Node3(7);
        root.right.left = new Node3(15);
        root.right.right = new Node3(8);

        int key = 12;
        root = GfG.insertNode(root, key);

        // After insertion 12 in binary tree
        //     10
        //    /  \
        //   11   9
        //  / \  / \
        // 7  12 15 8
        GfG.inorder(root);
    }
}

class Node3 {
    int data;
    Node3 left, right;

    Node3(int x) {
        data = x;
        left = right = null;
    }
}

class GfG {

    // Function to insert element in binary tree
    public static Node3 insertNode(Node3 root, int data) {

        // If the tree is empty, assign new node address to root
        if (root == null) {
            root = new Node3(data);
            return root;
        }

        // Else, do level order traversal until we find an empty
        // place, i.e., either left child or right child of some
        // node is pointing to NULL.
        Queue<Node3> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            // From a front element in queue
            Node3 curr = q.poll();

            // First check left if left is null insert node in left
            // otherwise check for right
            if (curr.left != null)
                q.add(curr.left);
            else {
                curr.left = new Node3(data);
                return root;
            }

            if (curr.right != null)
                q.add(curr.right);
            else {
                curr.right = new Node3(data);
                return root;
            }
        }

        return root;
    }

    // Inorder traversal of a binary tree
    public static void inorder(Node3 curr) {
        if (curr == null)
            return;
        inorder(curr.left);
        System.out.print(curr.data + " ");
        inorder(curr.right);
    }
}
