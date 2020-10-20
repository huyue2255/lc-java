package LaiOffer;

import Basic.test;

import java.util.*;

/**
 * Created by yuehu on 6/30/20.
 * Q: Have duplicate letters in input string
 * Q: Have duplicate letters in input array
 * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class PermutationsII {
    // Method 1(input string). DFS
    public List<String> permutations(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // index: at the level of index, we are to determine for the current permutation
    // which element is positioned at the index.
    private void helper(char[] array, int index, List<String> result) {
        if (index == array.length) {
            // base case: when we have determine for all the indices of
            // the current permutation which element to choose.
            result.add(new String(array));
            return;
        }

        // Notice: the rule is just for the current level, if a certain element
        // is picked, we can not pick any of its duplicates.
        // so that we use a set to record all the distinct elements.
        Set<Character> used = new HashSet<Character>();
        for (int i = index; i < array.length; i++) {
            if (used.add(array[i])) {
                swap(array, i, index);
                helper(array, index+1, result);
                swap(array,i,index);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    // Method 2(input array). DFS + back tracking + swap
    public List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> nums_lst = new ArrayList<>();
        for (int num : nums) {
            nums_lst.add(num);
        }
        dfs(nums_lst, res, 0);
        return res;
    }

    private void dfs(List<Integer> nums_lst, List<List<Integer>> res, int level) {
        if (level == nums_lst.size()) {
            res.add(new ArrayList<>(nums_lst));
        }
        HashSet<Integer> used = new HashSet<>();
        for (int i = level; i < nums_lst.size(); i++) {
            if (!used.contains(nums_lst.get(i))) {
                used.add(nums_lst.get(i));
                Collections.swap(nums_lst, i , level);
                dfs(nums_lst, res,level+1);
                Collections.swap(nums_lst,i,level);
            }
        }
    }

    // Method 3(input array). DFS + back tracking + used[boolean]
    public List<List<Integer>> permutationsIII(int[] nums) {
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
             if(used[i] || i > 0 && nums[i] == nums[i -1] && used[i-1] == false) continue;
             used[i] = true;
             list.add(nums[i]);
             helper(res, list, nums, used);
             used[i] = false;
             list.remove(list.size() - 1);
         }
     }

    public static void main(String[] args) {
        String test = "ABB";
        int[] test1 = {1,2,2};
        PermutationsII p = new PermutationsII();
        System.out.println(p.permutationsIII(test1));

    }
}
