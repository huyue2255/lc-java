package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 4/22/19.
 * Q:283
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros283 {
    public void moveZero(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while(nums.length - count > 0) {
            nums[count++] = 0;
        }
    }


    public static void main(String args[]) {
        int[] b = {1, 0, 0, 23, 2};

        MoveZeros283 s = new MoveZeros283();
        s.moveZero(b);
        System.out.println(Arrays.toString(b));
        System.out.println(b.length);
    }
}
