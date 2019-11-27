package Tree;

/**
 * Created by yuehu on 8/8/19.
 */
public class BalanceBinaryTree_110 {
    public boolean isBalance(TreeNode root) {
        if(root == null) return true;
        return helper(root) != -1;
    }

    public int helper(TreeNode root) {
        if(root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if(l == -1 || r == -1 || Math.abs(l-r) > 1){
            return -1;
        }
        return Math.max(l,r)+1;
    }
}
