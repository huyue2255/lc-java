package Tree;

/**
 * Created by yuehu on 8/9/19.
 */
public class MinimumDepthofBinaryTree_111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null){
            return Math.max(minDepth(root.left),minDepth(root.right))+1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
}
