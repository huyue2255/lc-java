package Array;

/**
 * Created by yuehu on 4/22/19.
 * Q53
 * Given an integer array nums,find the contiguous subarray
 * (containing at least one number) which has the largest sum and return its sum.
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] < 0 ? 0 : dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for(int i = 1; i < nums.length;i++){
            sum = Math.max(nums[i],sum + nums[i]);
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray53 a = new MaximumSubarray53();
        System.out.println(a.maxSubArray(s));
    }

}
