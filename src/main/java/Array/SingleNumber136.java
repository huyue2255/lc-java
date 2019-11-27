package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 5/25/19.
 * google面试题的变形：一个数组存放若干整数，一个数出现奇数次，其余数均出现偶数次，找出这个出现奇数次的数？
 * 136. Single Number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int i = 0;
        Arrays.sort(nums);
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums[0] != nums[1]) {
            return nums[0];
        }

        while(i < nums.length - 2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
            i = i+2;
        }
        return nums[nums.length - 1];
    }

    //异或运算，相同为0，不同为1.不需要考虑顺序，有交换律的
    //Time:O(n) Space:O(1)
    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
    public static void main(String args[]) {
        int[] nums = {2,2,3,4,6,4,3};
        SingleNumber136 s = new SingleNumber136();
        System.out.println(s.singleNumber2(nums));
//        System.out.println(4 ^ 6 ^ 4);

    }
}
