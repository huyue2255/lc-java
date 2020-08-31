package LaiOffer;

/**
 * Created by yuehu on 8/3/20.
 */
public class LargestSubarraySum {
    public int largestSum(int[] array) {
        int result = array[0];
        int cur = array[0];

        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            result = Math.max(result, cur);
        }
        return result;
    }

    public int largestSumI(int[] array) {
        // dp[i] means the largest sum of subarray ending at index i.
        // dp[i] = array[i]              if dp[i-1] <= 0
        //         dp[i-1] + array[i]    if dp[i-1] > 0
        // so that we can reduce the space consumption by recording the latest
        // largest sum
        // time: O(n) space; O(n)
        int[] dp = new int[array.length];
        int result = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = array[i] + (dp[i-1] < 0 ? 0 : dp[i-1]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    // find the left and right point
    public int largestSumII(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int left = 0;
        int sol_left = 0;
        int sol_right = 0;
        int global_max = Integer.MIN_VALUE;
        int[] M = new int[array.length];
        M[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if (M[i - 1] < 0) {
                M[i] = array[i];
                left = i;
            } else {
                M[i] = M[i-1] + array[i];
            }
            if (M[i] > global_max) {
                global_max = M[i];
                sol_left = left;
                sol_right = i;
            }
        }
        System.out.println("sol_left" + sol_left);
        System.out.println("sol_right" + sol_right);
        return global_max;
    }

    public static void main(String[] args) {
        int[] test = {-1,-1,-1,-1,0,0,10,0,0,-10};
        LargestSubarraySum s = new LargestSubarraySum();
        System.out.println(s.largestSumII(test));
    }
}
