package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yuehu on 7/16/19.
 */
public class Inorder {
    public List<Integer> inorder (TreeNode root){
      List<Integer> res = new ArrayList<>();
      if(root == null) return res;
      helper(res,root);
      return res;
    }

    private void helper(List<Integer> res, TreeNode root) {
        if(root == null) return;
        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);
    }

    public List<Integer> inorder2(TreeNode root) {
       List<Integer> res = new ArrayList<>();
       if(root == null) return res;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur = root;
       while(cur != null || !stack.isEmpty()){
           while(cur != null){
               stack.push(cur);
               cur = cur.left;
           }
           cur = stack.pop();
           res.add(cur.val);
           cur = cur.right;
       }
       return res;
    }

    private void print(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
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

        Inorder p = new Inorder();
        p.inorder(root);
    }

}
