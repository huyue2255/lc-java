package Basic;

import java.util.Arrays;

/**
 * Created by yuehu on 10/2/17.
 */
//leetcode num:169
// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        return nums[nums.length / 2];
    }
//
//        int majority = nums[0];
//        int count = 1;
//
//        for(int i = 1; i < nums.length; i++){
//            if(majority == nums[i]){
//                count++;
//            }else{
//                majority = nums[i];
//            }
//
//            if(count > nums.length / 2){
//                return majority;
//            }
//        }
//
//        return  majority;
//    }

    public static void main(String args[]){
        MajorityElement m = new MajorityElement();
        int[] a = {-1,1,1,1,3};
        System.out.println(m.majorityElement(a));
    }

}

//
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//
//        int maj = nums[0];
//        int count = 1;
//
//        for(int i = 1; i < nums.length; i++){
//            if(maj == nums[i]){
//                count++;
//            }else{
//                maj = nums[i];
//            }
//
//            if(count > nums.length / 2){
//                return maj;
//            }
//        }
//
//        return  maj;
//    }
