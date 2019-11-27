package LaiOffer;

/**
 * Created by yuehu on 11/23/19.
 * THIS BST WE DO NOT ALLOW THE DUPLICATE
 */
public class CheckBST {
    public boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.val < min || root.val > max) return false;
        return isBST(root.left, min, root.val-1)
                && isBST(root.right, root.val+1,max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(13);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;

        CheckBST p = new CheckBST();
        System.out.println(p.isBST(root));
    }
}
