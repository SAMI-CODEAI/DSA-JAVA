package lab.WEEK10;

public class InsertioninBinarySearchTree {
}

// Node class definition
class Nodeeee {
    int key;
    Nodeeee left, right;

    public Nodeeee(int item) {
        key = item;
        left = right = null;
    }
}

// GfG class with BST operations
class GfGggg {

    // A utility function to insert a new node with the given key
    static Nodeeee insert(Nodeeee root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            return new Nodeeee(key);
        }

        // If the key is already present in the tree, return the node
        if (root.key == key) {
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // A utility function to do inorder tree traversal
    static void inorder(Nodeeee root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    // Driver method
    public static void main(String[] args) {
        Nodeeee root = null;

        // Creating the following BST
        //       50
        //      /  \
        //     30   70
        //    / \  / \
        //   20 40 60 80

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        // Print inorder traversal of the BST
        inorder(root);
    }
}