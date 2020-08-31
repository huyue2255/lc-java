package LaiOffer;

/**
 * Created by yuehu on 7/3/20.
 * Q: Store Number Of Nodes In Left Subtree
 *
 * rules:(important)
 * 1. what do you expect from your lchild/rchild? usually it is the return type of the recursion function
 *    total number of nodes in my left subtree(1)
 *    total number of right in my right subtree(2)
 * 2. what so you want to do inthe current layer?
 *    store (1) in current -> lchildNum
 * 3. what do you want to report to your parent ? same as Q1 == Q3
 *
 */
public class NumNodeLeft {
    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        // stores the # of nodes in left subtree.
        int numNodesLeft;
    }

    public void numNodesLeft(TreeNode root) {
        numNodes(root);
    }

    private int numNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // leftNum is the # of nodes in subtree of root.left
        int leftNum = numNodes(root.left);

        // rightNum is the # of nodes in subtree of root.right
        int rightNum = numNodes(root.right);

        root.numNodesLeft = leftNum;
        // return the total # of nodes in the subtree of root.
        return leftNum + rightNum + 1;
    }
}
