package Basic;

/**Maximum Subarray
 * Created by yuehu on 10/1/17.标签: Divide and Conquer Array Dynamic Programming

 分析：最大连续子和问题，我们可以从头遍历数组，遍历到元素 i 时有两个选择：

 1.如果它大于等于零时，那就将它与前面的子和sum相加。

 2.如果它小于零时，则由该元素作为下一个子和sum的开头元素

 在遍历数组的同时记录最大的子和sumj即为最大连续子和；

 这里用动态规划的方法解决，设dp[i]表示从首元素到元素i的最大连续子和，所以有状态转移方程为：

 dp[i]=max(dp[i-1]+array[i],array[i]);
 */
public class MaximunSubarray {
    public int maxSubArray(int[] A) {
        int len = A.length;
        int ret = Integer.MIN_VALUE;
        int dp = 0;
        for (int i = 0; i < len; i++) {
            dp = Math.max(dp + A[i], A[i]);
            ret = Math.max(ret, dp);
        }
        return ret;


    }



    public static void main(String args[]) {
        MaximunSubarray b = new MaximunSubarray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,-4};
       // int[] a = {-1, -3, -2};

        System.out.println(b.maxSubArray(a));
        //System.out.println(Integer.MIN_VALUE);
    }
}




//        int[] dp = new int[nums.length];
//        int res = dp[0] = nums[0];
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//            res = Math.max(res, dp[i]);
//        }
//
//        return res;
//    }



//        int sum = 0;
//        int largest = nums[0];
//        int curSum = 0;
//        boolean allNeg = true;
//
//        for(int i = 0; i < nums.length; i++) {
//            if (nums[i] >= 0) {
//                allNeg = false;
//            }
//            largest = Math.max(largest, nums[i]);
//            curSum = Math.max(curSum + nums[i], 0);
//            sum = Math.max(curSum,sum);
//        }
//
//        if (allNeg) {
//            return largest;
//        }
//
//        return sum;
//    }