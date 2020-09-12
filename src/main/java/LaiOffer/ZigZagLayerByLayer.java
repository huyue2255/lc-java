package LaiOffer;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by yuehu on 9/2/20.
 * even 偶数 / odd 奇数
 * tree:
 *          3 (left -> right)
 *        /   \
 *       9     8 (right -> left)
 *      / \   / \
 *     4  5  11 71
 *    / \  \
 *   2  10 13
 */
public class ZigZagLayerByLayer {
    public List<List<Integer>> zigZag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean x = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(x){
                    list.add(cur.val);
                }else {
                    list.add(0,cur.val);
                }

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

            res.add(list);
            x = x ? false : true;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(11);
        TreeNode t6 = new TreeNode(71);
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
//        t4.left = t9;
        t4.right = t10;
        ZigZagLayerByLayer z = new ZigZagLayerByLayer();
        System.out.println(z.zigZag(root));
    }
}
