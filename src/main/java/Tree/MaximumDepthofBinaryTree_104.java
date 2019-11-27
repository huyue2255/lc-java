package Tree;

/**
 * Created by yuehu on 8/8/19.
 */
public class MaximumDepthofBinaryTree_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) return 0;
        int l = maxDepth2(root.left) + 1;
        int r = maxDepth2(root.right) + 1;
        return Math.max(l,r);
    }
}
