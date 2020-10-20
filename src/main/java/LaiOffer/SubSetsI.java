package LaiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 5/25/20.
 * Assumptions:
 * 1) there are no duplicate characters in the given string.
 *
 */
public class SubSetsI {
    //method 1: DFS solution + input String
    public List<String> subSets(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        // record the current subset.
        StringBuilder sb = new StringBuilder();
        helper(arraySet, sb, 0, result);
        return result;
    }

    // at each level, determine the character at the position "index" to be picked or not
    private void helper(char[] set, StringBuilder sb, int index, List<String> result) {
        // terminate condition:
        // when we finishes determining for all the characters pick or not
        if (index == set.length) {
            result.add(sb.toString());
            return;
        }

        // 1. not pick the character at index
        helper(set, sb, index + 1, result);
        // 2. pick the character at index
        helper(set, sb.append(set[index]), index + 1, result);

        sb.deleteCharAt(sb.length() - 1);
    }


    //method 2: DFS solution + input String
    public List<String> subSetsI(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }

        char[] arraySet = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helperI(arraySet, sb, 0, result);
        return result;
    }

    private void helperI(char[] set, StringBuilder sb, int index, List<String> result) {
        result.add(sb.toString());
        // maintains ascending order of the indices of picked characters
        // choose the next picked index (the smallest one can be picked is index)

        for (int i = index; i < set.length; i++) {
            sb.append(set[i]);
            helperI(set, sb, i + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    // method 3: DFS solution + input array
    public List<List<Integer>> subSetsII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helperII(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    private void helperII(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helperII(res, list, nums,index+1);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        String res = "abc";

        SubSetsI s = new SubSetsI();
        System.out.println(s.subSets(res));

    }

}
