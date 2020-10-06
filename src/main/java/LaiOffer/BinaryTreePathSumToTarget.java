package LaiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yuehu on 9/19/20.
 * Q: Binary Tree Path sum to target (the twp nodes can be same node and they
 * can only be on the path from root to one of the leaf nodes)
 *
 *          3 (left -> right)
 *        /   \
 *       9     8 (right -> left)
 *      / \   / \
 *     4  5  11 71
 *    / \  \
 *   2  10 13
 */
public class BinaryTreePathSumToTarget {
    // Method 1:
    public boolean exist (TreeNode root, int sum) {
        if (root == null) return false;
        // pass down the prefix of the path.
        List<TreeNode> path = new ArrayList<TreeNode>();
        return helper(root,path,sum);
    }

    private boolean helper (TreeNode root, List<TreeNode> path, int sum) {
        path.add(root);
        // check if can find a subpath ended at root node,
        // the sum of the subpath is target
        int tmp = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            tmp += path.get(i).val;
            if (tmp == sum) {
                return true;
            }
        }
        if (root.left != null && helper(root.left, path, sum)) {
            return true;
        }
        if (root.right != null && helper(root.right, path, sum)){
            return true;
        }
        // don't forget for the cleanup when return to the previous level
        path.remove(path.size() - 1);
        return false;
    }

    // Method 2: an O(n) solution.
    // Think about the related problem, how do you find if there is
    // a subarray sum to target value?
    // If there is an O(n) solution to the above problem, we can extend
    // it to each of the root->leaf paths of the binary tree.
    public boolean existII (TreeNode root, int sum) {
        if (root == null) return false;
        Set<Integer> prefixSums = new HashSet<>();
        prefixSums.add(0);
        return helperII(root, prefixSums, 0, sum);
    }

    private boolean helperII(TreeNode root, Set<Integer> prefixSums, int prevSum, int sum) {
        prevSum += root.val;
        if (prefixSums.contains(prevSum - sum)) {
            return true;
        }
        boolean needRemove = prefixSums.add(prevSum);
        if (root.left != null && helperII(root.left, prefixSums, prevSum, sum)) {
            return true;
        }
        if (root.right != null && helperII(root.right, prefixSums, prevSum, sum)) {
            return true;
        }
        if (needRemove) {
            prefixSums.remove(prevSum);
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTreePathSumToTarget b = new BinaryTreePathSumToTarget();
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
        System.out.println(b.exist(root, 79));
    }


}
