package LaiOffer;

/**
 * Created by yuehu on 9/28/20.
 */
public class BinaryTreeUpsideDown {
    // Method 1：Recursion
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //    if (root == null || root.left == null) {
    //        return root;
    //    }
    //     TreeNode newRoot = upsideDownBinaryTree(root.left);
    //     root.left.left = root.right;
    //     root.left.right = root;
    //     root.left = null;
    //     root.right = null;
    //     return newRoot;
    // }

    // Method 2: Iterative
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode node = root, parent = null, right = null;
        while (node != null) {
            TreeNode left = node.left;
            node.left = right;
            right = node.right;
            node.right = parent;
            parent = node;
            node = left;
        }
        return parent;
    }
}
