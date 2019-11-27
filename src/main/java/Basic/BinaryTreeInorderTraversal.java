package Basic;

import java.util.ArrayList;

import java.util.*;

/**
 * Created by yuehu on 10/20/17.
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.left != null) {
                stack.push(top.left);
            } else {
                result.add(top.val);
                stack.pop();
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }

        return result;
    }

}
