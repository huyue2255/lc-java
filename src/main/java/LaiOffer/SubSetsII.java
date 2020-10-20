package LaiOffer;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 10/12/20.
 * Q90: Given a collection of integers that might contain duplicates,
 *      nums, return all possible subsets (the power set).
 */
public class SubSetsII {
    public List<List<Integer>> subsetsII(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(res,list,nums,i+1);
            list.remove(list.size() - 1);
        }
    }

}
