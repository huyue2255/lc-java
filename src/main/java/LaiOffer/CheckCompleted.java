package LaiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuehu on 2/29/20.
 */
public class CheckCompleted {
    public boolean isComplete(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // if the flag is set true, there should not be any child nodes afterwards.
        boolean flag = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // if any of the child is not present, set the flag to true
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                // if flag is set but we still see cur has a left child
                //the binary tree is not a completed one.
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(12);
        TreeNode t10 = new TreeNode(13);

        root.left = t1;
        root.right = t2;
//        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
//        t3.left = t7;
//        t3.right = t8;
//        t4.left = t9;
//        t4.right = t10;

        CheckCompleted s = new CheckCompleted();
        System.out.println(s.isComplete(root));
    }
}
