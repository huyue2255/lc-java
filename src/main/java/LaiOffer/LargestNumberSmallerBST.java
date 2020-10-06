package LaiOffer;

/**
 * Created by yuehu on 9/13/20.
 */
public class LargestNumberSmallerBST {
    public int largestSmaller(TreeNode root, int target) {
        // Assumptioms: the binary search tree is not null
        int result = Integer.MIN_VALUE;
        while (root != null) {
            if (root.val >= target) {
                root = root.left;
            } else {
                // cur.value < target
                // previous best < cur.value < target
                result = root.val;
                root = root.right;
            }
        }
        return result;
    }



}
