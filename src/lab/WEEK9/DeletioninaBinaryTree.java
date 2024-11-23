package lab.WEEK9;

import java.util.LinkedList;
import java.util.Queue;

public class DeletioninaBinaryTree {

    public static void main(String[] args) {
        // Construct the binary tree
        //        10
        //       /  \
        //      11   9
        //     / \  / \
        //    7  12 15 8
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        int key = 11;
        root = BinaryTreeOperation.deletion(root, key);
        BinaryTreeOperation.inorder(root);
    }
}

class TreeNode2 {
    int data;
    TreeNode left, right;

    TreeNode2(int x) {
        data = x;
        left = right = null;
    }
}

class BinaryTreeOperation {

    // Function to delete the deepest node in a binary tree
    static void deleteDeepest(TreeNode root, TreeNode dNode) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode curr;
        while (!q.isEmpty()) {
            curr = q.poll();

            // If current node is the deepest node, delete it
            if (curr == dNode) {
                curr = null;
                dNode = null;
                return;
            }

            if (curr.left != null) {
                if (curr.left == dNode) {
                    curr.left = null;
                    return;
                } else {
                    q.add(curr.left);
                }
            }

            if (curr.right != null) {
                if (curr.right == dNode) {
                    curr.right = null;
                    return;
                } else {
                    q.add(curr.right);
                }
            }
        }
    }

    // Function to delete a node with given key in a binary tree
    static TreeNode deletion(TreeNode root, int key) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (root.data == key)
                return null;
            else
                return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        TreeNode temp = null, keyNode = null;

        // Level order traversal to find the deepest node and the key node
        while (!q.isEmpty()) {
            temp = q.poll();

            if (temp.data == key)
                keyNode = temp;

            if (temp.left != null)
                q.add(temp.left);

            if (temp.right != null)
                q.add(temp.right);
        }

        // If key node is found, replace its data with the deepest node
        if (keyNode != null) {
            int x = temp.data;
            deleteDeepest(root, temp);
            keyNode.data = x;
        }

        return root;
    }

    // Inorder traversal of a binary tree
    static void inorder(TreeNode curr) {
        if (curr == null)
            return;
        inorder(curr.left);
        System.out.print(curr.data + " ");
        inorder(curr.right);
    }
}
