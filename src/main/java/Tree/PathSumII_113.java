package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/9/19.
 * Given the below binary tree and sum = 22,

       5
      /  \
     4    8
    /    / \
   11   13  4
  /  \     / \
 7    2   5   1
 Return:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        helper(res,new ArrayList<>(),root, sum);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> list, TreeNode root, int sum) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val){
                res.add(new ArrayList<>(list));
            }
        }
        helper(res,list,root.left,sum - root.val);
        helper(res,list,root.right,sum - root.val);
        list.remove(list.size() - 1);
    }
}
