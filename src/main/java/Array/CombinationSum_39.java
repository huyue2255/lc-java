package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 7/16/19.
 */
public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }

        helper(res, new ArrayList<>(), candidates, target,0);
        return res;
    }


    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res,list,candidates, target - candidates[i],0);
            res.remove(res.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] src = {1,7};
        CombinationSum_39 c = new CombinationSum_39();
        System.out.println(c.combinationSum(src,7));
    }

}
