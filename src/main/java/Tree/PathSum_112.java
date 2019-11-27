package Tree;

import java.util.Stack;

/**
 * Created by yuehu on 8/9/19.
 */
public class PathSum_112 {
    public boolean hasPathSum(TreeNode root,int sum) {
        if(root == null) return false;
        if(root.left == null || root.right == null){
            return sum == root.val;
        }
        return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);
    }


    public boolean hasPathSum2(TreeNode root,int sum) {
        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left == null && cur.right == null){
                if(cur.val == sum){
                    return true;
                }
            }

            if(cur.right != null){
                stack.push(cur.right);
                cur.right.val += cur.val;
            }

            if(cur.left != null){
                stack.push(cur.left);
                cur.left.val += cur.val;
            }
        }
        return false;
    }
}
