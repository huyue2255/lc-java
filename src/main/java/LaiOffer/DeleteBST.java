package LaiOffer;

/**
 * Created by yuehu on 9/13/20.
 * Complexity Analysis: time and space logN
 * Algorithm

 If key > root.val then delete the node to delete is in the right subtree root.right = deleteNode(root.right, key).

 If key < root.val then delete the node to delete is in the left subtree root.left = deleteNode(root.left, key).

 If key == root.val then the node to delete is right here. Let's do it :

 If the node is a leaf, the delete process is straightforward : root = null.

 If the node is not a leaf and has the right child, then replace the node value by a successor value root.val = successor.val,
 and then recursively delete the successor in the right subtree root.right = deleteNode(root.right, root.val).

 If the node is not a leaf and has only the left child, then replace the node value by a predecessor value root.val = predecessor.val,
 and then recursively delete the predecessor in the left subtree root.left = deleteNode(root.left, root.val).

 Return root.
 */
public class DeleteBST {
    //Method 1
    /*
    One step right and then always left
    Successor = "after node", i.e. the next node, or the smallest node after the current one.
    */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    Predecessor = "before node", i.e. the previous node, or the largest node before the current one.
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
}
