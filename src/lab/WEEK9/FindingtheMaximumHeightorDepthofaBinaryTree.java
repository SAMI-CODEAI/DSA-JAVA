package lab.WEEK9;

public class FindingtheMaximumHeightorDepthofaBinaryTree {

    public static void main(String[] args) {
        // Representation of the input tree:
        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Height of the binary tree: " + BinaryTreeOperations.height(root));
    }
}

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class BinaryTreeOperations {

    // Returns height which is the number of edges
    // along the longest path from the root node down
    // to the farthest leaf node.
    public static int height(TreeNode root) {
        if (root == null)
            return -1;

        // Compute the height of left and right subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }
}
