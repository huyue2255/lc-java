package LaiOffer;

import apple.laf.JRSUIUtils;

import javax.swing.*;

/**
 * Created by yuehu on 7/3/20.
 * Q: Given a binary tree, find the node with the max difference
 * in the total number descendents in its left subtree and right subtree
 */
public class MaxDiffNode {
    public TreeNode MaxDiffNode(TreeNode root ) {
        if (root == null) {
            return null;
        }

        TreeNode[] node = new TreeNode[1];
        int[] diff = new int[1];
        diff[0] = -1;
        numNodes(root, node, diff);
        return node[0];
    }

    // return the # of nodes in subtree.
    private int numNodes(TreeNode root, TreeNode[] node, int[] diff) {
        if (root == null) {
            return 0;
        }

        int leftNum = numNodes(root.left, node, diff);
        int rightNum = numNodes(root.right, node, diff);
        if (Math.abs(leftNum - rightNum) > diff[0]) {
            node[0] = root;
            diff[0] = Math.abs(leftNum - rightNum);
        }
        return leftNum + rightNum + 1;
    }
}
