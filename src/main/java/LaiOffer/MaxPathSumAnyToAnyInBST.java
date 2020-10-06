package LaiOffer;

/**
 * Created by yuehu on 9/19/20.
 * Q: (人字形path问题)
 * Get Maximum sum of the path cost from any node to any node (not necessary from leaf to leaf)
 * way of thinking (Tricks)
 * 1. what do you expect from your lchild/rchild?
 *      Max single path in my left subtree that starts from lchild(1)
 *      Max single path in my right subtree that starts from rchild(2)
 * 2. what do you want to do in the current layer?
 *      global_max = max(global_max, max(left,0), max(right, 0)) + root.value
 * 3. what do you want to report to your parent? (same as Q1 == Q3)
 *      it is usually the return type of the Recursion function
 *      root.value + max(left,right,0)
 *          3 (left -> right)
 *        /   \
 *       9     8 (right -> left)
 *      / \   / \
 *     4  5  11 71
 *    / \  \
 *   2  10 13
 */

public class MaxPathSumAnyToAnyInBST {

// Method 1:
    private int maxPathSum (TreeNode root, int[] max) {
        if (root == null) return 0;
        // step 1
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);

        // step 2
        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;
        max[0] = Math.max(max[0], root.val + left + right);

        // step 3
        return Math.max(left, right) + root.val;
    }

    public int findMaxPathCost(TreeNode root) {
        // Assumptions: root is not null
        // result stores the global maximum path sum and will be

        int[] result = new int[] {Integer.MIN_VALUE};
        maxPathSum(root, result);
        return result[0];
    }

    public static void main(String[] args) {

        MaxPathSumAnyToAnyInBST m = new MaxPathSumAnyToAnyInBST();
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
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
