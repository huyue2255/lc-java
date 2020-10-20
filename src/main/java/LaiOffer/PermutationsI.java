package LaiOffer;

import java.util.*;

/**
 * Created by yuehu on 6/7/20.
 * Given a string with no duplicated letters, how to print out all permutations of the string
 */
public class PermutationsI {
    // Method 1(input: string). DFS solution with swapping
    public List<String> permutation(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] array = set.toCharArray();
        helper(array, 0, result);
        return result;
    }

    // choose the character to be at the position of "index"
    // all the already chosen positions are (0, index - 1)
    // all the candidate characters can be at position "index"
    // are in the subarray of (index, array.length - 1)

    private void helper(char[] array, int index, List<String> result) {
        // terminate condition:
        // only when we have already chosen the characters for all the position,
        // we can have a complete permutation
        if (index == array.length) {
            result.add(new String(array));
            return;
        }

        // all the possible characters could be placed at index are
        // the characters in the sub-array of (index, array.length - 1)
        for (int i = index; i < array.length; i++) {
            swap(array, index, i);
            helper(array, index+1, result);
            // remember to swap back when back track to previous level.
            swap(array, index, i);
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    // Method 2(input: string). solution to maintain the order of all the permutations.

    public List<String> permutationsWithOrder(String set) {
        List<String> result = new ArrayList<String>();
        if (set == null) {
            return result;
        }
        char[] arraySet = set.toCharArray();
        Arrays.sort(arraySet);
        // record which index has been used in the original arraySet.
        boolean[] used = new boolean[arraySet.length];
        StringBuilder cur = new StringBuilder();
        helperWithOrder(arraySet, used, cur, result);
        return result;
    }

    private void helperWithOrder(char[] array, boolean[] used, StringBuilder cur, List<String> result) {
        // terminate condition:
        // when the permutation contains all the characters in the original array
        if (cur.length() == array.length) {
            result.add(cur.toString());
            return;
        }
        // when picking the next char, always according to the order.
        for (int i = 0; i < array.length; i++) {
            // if the character is already used, we can not pick it for second time
            if (!used[i]) {
                used[i] = true;
                cur.append(array[i]);
                helperWithOrder(array,used,cur,result);
                used[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }


    // Method 3(input array). DFS + back tracking
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // corner case
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited,false);
        dfs(res, nums,new ArrayList<>(), visited);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, List<Integer> subset, boolean[] visited) {
        // exit rule
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                subset.add(nums[i]);
                visited[i] = true;
                dfs(res,nums,subset,visited);
                subset.remove(subset.size() - 1);
                visited[i] = false;
            }
        }
    }

    // Method 4(input array). DFS + back tracking + swap
    public List<List<Integer>> permuteII(int[] nums) {
        // init output list
        List<List<Integer>> output = new ArrayList<>();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    // Method 5(input array + without visited). DFS + back tracking
    public List<List<Integer>> permuteIII(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        dfsI(res,nums, new ArrayList<>());
        return res;
    }

    private void dfsI(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfsI(res,nums,list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] test = {1,2,3};
        PermutationsI s = new PermutationsI();
        System.out.println(s.permuteII(test));
    }

}
