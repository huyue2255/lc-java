package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuehu on 5/30/19.
 */
public class LongestContinuousIncreSubsequesnce674 {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int curLen = 1;
        int ans = 1;


        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                curLen++;
                ans = Math.max(ans,curLen);
            }else {
                curLen = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] e = {1,2,5,4,7,8,9,10};
        LongestContinuousIncreSubsequesnce674 s = new LongestContinuousIncreSubsequesnce674();
        System.out.println(s.findLengthOfLCIS(e));
    }
}
