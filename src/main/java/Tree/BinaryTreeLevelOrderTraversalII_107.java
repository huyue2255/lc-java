package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yuehu on 8/8/19.
 */
public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelPrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                list.add(cur.val);
            }

            res.add(0,list);
        }
        return res;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(res,root,0);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int level) {
        if(root == null) return;;
        if(level >= res.size()){
            res.add(0,new ArrayList<>());
        }

        res.get(0).add(root.val);
        helper(res,root.left,level + 1);
        helper(res,root.right,level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);

        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        BinaryTreeLevelOrderTraversalII_107 s = new BinaryTreeLevelOrderTraversalII_107();
        System.out.println(s.levelOrderBottom2(root));

    }
}
