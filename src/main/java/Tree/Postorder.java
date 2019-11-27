package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuehu on 7/16/19.
 */
public class Postorder {
    public void postorder(TreeNode root) {
        if(root == null) return;
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        print(res);
    }

    private void helper(List<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res,root.left);
        helper(res,root.right);
        res.add(root.val);
    }

    private void print(List<Integer> res) {
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i) + " ");
        }
    }

    public void postorder2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if(cur.left != null) {
                stack.push(cur.left);
            }

            if(cur.right != null) {
                stack.push(cur.right);
            }

            res.addFirst(cur.val);
        }
        print(res);
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
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        t4.left = t9;
        t4.right = t10;
        Postorder p = new Postorder();
        p.postorder2(root);
    }
}
