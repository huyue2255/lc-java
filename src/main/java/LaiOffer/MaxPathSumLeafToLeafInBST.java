package LaiOffer;

/**
 * Created by yuehu on 9/19/20.
 * Q: Given a binary tree in which each node element contains a number,
 * Find the maximum possible sum from one leaf node to another.
 * (the maximum sum path may or may not go through root.
 *
 * way of thinking (Tricks)
 * 1. what do you expect from your lchild / rchild?
 *      Max single path in my left subtree(1)
 *      Max single path in my right subtree (2)
 * 2. what do you want to do in the current layer?
 *      update global_max = left + right + root.value if feasible
 * 3. what do you want to report to your parent? (same as Q1 == Q3)
 *      it is usually the return type of the recursion function
 *
 *
 *          3 (left -> right)
 *        /   \
 *       9     8 (right -> left)
 *      / \   / \
 *     4  5  11 71
 *    / \  \
 *   2  10 13
 */
public class MaxPathSumLeafToLeafInBST {
    private int maxPathSum (TreeNode root, int[] result) {
        if (root == null) return 0;
        // Find maximum sum in left and right subtree.
        int lcost = maxPathSum(root.left, result);
        int rcost = maxPathSum(root.right, result);
        // Find the maximum path sum passing through root
        int currSum = lcost + rcost + root.val;

        // update res or result only when needed
        if (result[0] < currSum && (root.left != null && root.right != null)) {
            result[0] = currSum;
        }

        // return the maximum (root to leaf path) cost
        if (root.left == null) {
            return root.val + rcost;
        } else if (root.right == null) {
            return root.val + lcost;
        }
        return Math.max(lcost,rcost) + root.val;
    }

    // The main function which returns sum of the maximum
    // sum path between two leaves. This function mainly uses maxPathSum()
    public int findMaxPathCost(TreeNode root) {
        int[] result = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, result);
        return result[0];
    }

    public static void main(String[] args) {
        MaxPathSumLeafToLeafInBST m = new MaxPathSumLeafToLeafInBST();
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(-90);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(71);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(12);
        TreeNode t10 = new TreeNode(13);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
//        t4.left = t9;
        t4.right = t10;
        System.out.println(m.findMaxPathCost(root));
    }
}
