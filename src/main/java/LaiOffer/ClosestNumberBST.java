package LaiOffer;

/**
 * Created by yuehu on 9/13/20.
 *
 */
public class ClosestNumberBST {
    // Assumptions: the given binary search tree is not null.
    public int closeast(TreeNode root, int target) {
        int result = root.val;
        // The closest number has to be on the path of finding
        // the target value in the binary search tree
        while (root != null) {
            if (root.val == target) {
                return root.val;
            } else {
                if (Math.abs(root.val - target) < Math.abs(result - target)) {
                    result = root.val;
                }
                if (root.val < target) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }

        }
        return result;
    }

    // Recursion
    int goal;
    double min = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        helper(root, target);
        return goal;
    }

    public void helper(TreeNode root, double target){
        if(root==null)
            return;

        if(Math.abs(root.val - target) < min){
            min = Math.abs(root.val-target);
            goal = root.val;
        }

        if(target < root.val){
            helper(root.left, target);
        }else{
            helper(root.right, target);
        }
    }
}
