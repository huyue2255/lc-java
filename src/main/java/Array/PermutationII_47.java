package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehu on 7/30/19
 */
public class PermutationII_47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        helper(res, new ArrayList<>(),nums, new boolean[nums.length]);
        return res;
    }


    public void helper(List<List<Integer>> res,List<Integer> list, int[] nums, boolean[] used) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }

        for(int i = 0; i < nums.length; i++) {
//            if(used[i] || i > 0 && nums[i] == nums[i -1] && !used[i-1]) continue;
            if(used[i]) continue;

            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public void print(List<List<Integer>> list) {

    }

    public static void main(String[] args) {
        int[] s1 = {1,1,3};
        PermutationII_47 s = new PermutationII_47();
        System.out.println(s.permuteUnique(s1));
        //System.out.println(s1);
    }



}
