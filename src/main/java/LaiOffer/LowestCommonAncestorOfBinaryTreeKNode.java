package LaiOffer;

/**
 * Created by yuehu on 9/3/20.
 * Generate ideas to solve k-something
 * 这道题让我们求二叉搜索树的最小共同父节点, LeetCode中关于BST的题有
 * Validate Binary Search Tree， Recover Binary Search Tree，
 * Binary Search Tree Iterator， Unique Binary Search Trees，
 * Unique Binary Search Trees II，Convert Sorted Array to Binary Search Tree ,
 * Convert Sorted List to Binary Search Tree 和 Kth Smallest Element in a BST。
 * 这道题我们可以用递归来求解，我们首先来看题目中给的例子，
 * 由于二叉搜索树的特点是 左<根<右，所以根节点的值一直都是中间值，大于左子树的所有节点值，
 * 小于右子树的所有节点值，那么我们可以做如下的判断，如果根节点的值大于p和q之间的较大值，
 * 说明p和q都在左子树中，那么此时我们就进入根节点的左子节点继续递归，如果根节点小于p和q之间的较小值，
 * 说明p和q都在右子树中，那么此时我们就进入根节点的右子节点继续递归，如果都不是，
 * 则说明当前根节点就是最小共同父节点，直接返回即可
 *
 *  *       6 (left -> right)
 *        /   \
 *       2     8 (right -> left)
 *      / \   / \
 *     0  4  7  9
 *       / \
 *      3  5
 */
public class LowestCommonAncestorOfBinaryTreeKNode {
    public TreeNode LCAOfBST(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null || a == root || b == root) {
            return root;
        }

        if (root.val > Math.max(a.val,b.val)) {
            return LCAOfBST(root.left,a,b);
        } else if (root.val < Math.min(a.val,b.val)) {
            return LCAOfBST(root.right,a,b);
        } else {
            return root;
        }
    }
    public static void main(String[] args) {
        LowestCommonAncestorOfBinaryTreeKNode l = new LowestCommonAncestorOfBinaryTreeKNode();
        TreeNode root = new TreeNode(6);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t9 = new TreeNode(3);
        TreeNode t10 = new TreeNode(5);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t4.left = t9;
        t4.right = t10;

        System.out.println(l.LCAOfBST(root, t9, t10).val);
    }

}
