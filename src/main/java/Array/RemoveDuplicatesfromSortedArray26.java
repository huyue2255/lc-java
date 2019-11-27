package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehu on 2/6/19.
 * 26
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 Given nums = [1,1,2],
 [0,0,1,1,1,2,3,3,4]
          c
                  i
 0,1,2,3,4


 nums[j]: 0, 1,
 */
public class RemoveDuplicatesfromSortedArray26 {


    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 1;
        }

        if(nums.length == 1) {
            return 1;
        }
      int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[count-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public void displayArray(int[] nums) {
        for(int i =0 ; i < nums.length ; i++) {
            System.out.println(nums[i] + " ");
        }
    }


    //        int[] a = new int[res.size()];
//        int l =0;
//        for(int item:res){
//            a[l++]=item;
//        }
//        return a;
    public static void main(String args[]){
        int[] b = {0,0,1,1,1,2,3,4};
        int[] a = {1,4,2,3,6,7,3};
        Arrays.sort(a);
        RemoveDuplicatesfromSortedArray26 s = new RemoveDuplicatesfromSortedArray26();


        System.out.println(s.removeDuplicates(a));
        int result[] = Arrays.copyOfRange(a, 0, 6);
        System.out.println(Arrays.toString(result));

    }

}
