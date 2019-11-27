package LaiOffer;

/**
 * Created by yuehu on 11/23/19.
 */
public class CheckTweakedIdentical {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.val != two.val) {
            return false;
        }

        return isTweakedIdentical(one.left,two.left) && isTweakedIdentical(one.right,two.right) ||
                isTweakedIdentical(one.left,two.right) && isTweakedIdentical(one.right,two.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(12);
        TreeNode t9 = new TreeNode(12);
        TreeNode t10 = new TreeNode(2);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        t6.left = t9;
        t6.right = t10;

        CheckTweakedIdentical p = new CheckTweakedIdentical();
        System.out.println(p.isTweakedIdentical(root.left,root.right));
    }
}
