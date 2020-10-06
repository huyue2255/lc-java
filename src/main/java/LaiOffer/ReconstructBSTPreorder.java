package LaiOffer;

import apple.laf.JRSUIUtils;

/**
 * Created by yuehu on 9/23/20.
 * Q: 1008
 *
 */
public class ReconstructBSTPreorder {
    public TreeNode reconstruct (int[] pre) {
        // Assumptions: post is not null
        // there is no duplicate in the binary search tree
        // Traversing position of the post order,
        // We traverse and construct the binary search tree
        // from the postOrder right to left.
        return helper(pre, 0, pre.length);
    }

    private TreeNode helper (int[] pre, int start, int end) {
        if (start >= end) {
            return null;
        }
        TreeNode root = new TreeNode(pre[start]);
        int splitNum = start;
        while (splitNum < end && pre[start] >= pre[splitNum]) {
            splitNum++;
        }
        root.left = helper(pre, start + 1, splitNum);
        root.right = helper(pre,splitNum, end);
        return root;
    }

}
