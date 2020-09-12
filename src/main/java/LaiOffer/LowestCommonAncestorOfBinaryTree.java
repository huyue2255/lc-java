package LaiOffer;

import java.util.*;

/**
 * Created by yuehu on 9/3/20.
 * https://www.cnblogs.com/grandyang/p/4641968.html
 * https://zxi.mytechroad.com/blog/tree/leetcode-236-lowest-common-ancestor-of-a-binary-tree/
 * Q: Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * (where we allow a node to be a descendant of itself)
 * All of the nodes’ values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * Solution 1: Recursion
 *   Time complexity: O(n)
 *   Space complexity: O(h)
 *   For a given root, recursively call LCA(root.left, p, q) and LCA(root.right, p, q)
 *   if both returns a valid node which means p, q are in different subtrees, then root will be their LCA.
 *   if only one valid node returns, which means p, q are in the same subtree, return that valid node as their LCA.

 *          3 (left -> right)
 *        /   \
 *       9     8 (right -> left)
 *      / \   / \
 *     4  5  11 71
 *    / \  \
 *   2  10 13

 */
public class LowestCommonAncestorOfBinaryTree {
    // without parent pointer
    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a,b);

        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    // assume we do have parent pointer in each node
    // Solution 2:
    // Step1: From a, keep looking up, and store all ancestors of a to HashSet
    // Step2: From b, keep looking up one by one, until we find the current node in the HashSet.
    public TreeNode LCAI(TreeNode root, TreeNode p, TreeNode q ) {
        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        // HashMap for parent pointers
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestors set() is their lowest common ancestors.
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;



    }

    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTree l = new LowestCommonAncestorOfBinaryTree();
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

        System.out.println(l.LCAI(root, t3, t8).val);
    }
}
