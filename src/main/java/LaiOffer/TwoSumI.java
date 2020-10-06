package LaiOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 9/28/20.
 * Q: Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 */
public class TwoSumI {
    // brute force
    // time complexity: O(n^2)
    // space complexity: O(1)
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    // one-pass Hash table
    public int[] twoSumI(int[] nums, int target) {
        Map<Integer, Integer>  map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0};
//        throw new IllegalArgumentException("No two sum solution");
    }

    public int[] twoSumII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return  null;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,4,4};
        TwoSumI t = new TwoSumI();
        System.out.println(Arrays.toString(t.twoSum(nums,8)));
    }
}
