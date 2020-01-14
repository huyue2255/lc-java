package LaiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuehu on 2/8/20.
 */
public class CheckCompleted {
    public boolean isCompleted(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // if the flag is set true, there should not be ant child nodes afterwards.
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                //if flag is set but we still see cur has a left child
                //the binary tree is not a complete one
                return false;
            } else {
                //if flag is not set and left child is present
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
