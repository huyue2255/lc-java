package Tree;

import java.util.Stack;

/**
 * Created by yuehu on 8/9/19.
 */
public class FlattenBinaryTreeLinkedList_114 {
    private TreeNode pre = null;
    public void flatten(TreeNode root){
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public void flatten2(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
            if(!stack.isEmpty()){
                cur.right = stack.peek();
            }
            cur.left = null;

        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = e;
        b.left = c;
        b.right = d;
        e.right = f;

        FlattenBinaryTreeLinkedList_114 s = new FlattenBinaryTreeLinkedList_114();
        s.flatten2(a);
        System.out.println(a.right.val);
        System.out.println(a.right.right.val);
        System.out.println(a.right.right.right.val);
        System.out.println(a.right.right.right.right.val);
        System.out.println(a.right.right.right.right.right.val);


    }
}
