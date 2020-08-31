package LaiOffer;

/**
 * Created by yuehu on 8/20/20.
 * Q: Given a binary array, find the maximum number of consecutive 1s in this array.
 * Base case: M[0] = input[0] only one element in input
 * Induction rule: M[i] represents form 0th element to the ith element,
 * the longest contiguous 1s, (including the ith element.)
 * M[i] = 1 + M[i-1]  => input[i] == 1
 *
 */
public class LongestConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        int maxCount = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                res[i] = 1 + res[i-1];
            } else {
                maxCount = Math.max(maxCount, res[i-1]);
                res[i] = 0;
            }
        }
        return Math.max(maxCount, res[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] test = {1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1};
        LongestConsecutiveOnes s = new LongestConsecutiveOnes();
        System.out.println(s.findMaxConsecutiveOnes(test));
    }

}
