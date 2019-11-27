package LaiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 11/23/19.
 */
public class CheckRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> list = new ArrayList<>();
        getRange(root, min, max, list);
        return list;
    }

    private void getRange(TreeNode root, int min, int max, List<Integer> list) {
        if (root == null) return;

        if (root.val > min) {
            getRange(root.left,min,max,list);
        }
        if (root.val >= min && root.val <= max) {
            list.add(root.val);
        }
        if (root.val < max) {
            getRange(root.right,min,max,list);
        }

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(13);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(3);

        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;

        CheckRange p = new CheckRange();
        System.out.println(p.getRange(root,1,10));
    }
}
