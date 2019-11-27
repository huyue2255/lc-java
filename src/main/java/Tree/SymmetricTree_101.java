package Tree;

/**
 * Created by yuehu on 8/8/19.
 */
public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }

    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return helper(q.left,p.right) && helper(q.right,p.left);
    }
}
