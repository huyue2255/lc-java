package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 5/25/19.
 * Q:561
 */
public class ArrayPairSum {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i = i+2) {
            sum = sum + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,6,7,9};
        ArrayPairSum s = new ArrayPairSum();
        System.out.println(s.arrayPairSum(a));
    }
}
