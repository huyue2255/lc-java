package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by yuehu on 3/25/19.
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
//一种是返回数字，一种是返回一个数组
public class RemoveElement27 {
    public int[] removeElement (int nums[], int val) {
      int res = 0;
      List<Integer> list = new ArrayList<>();
      for(int i = 0; i < nums.length; i++){
          if(nums[i] != val) {
              nums[res++] = nums[i];
              list.add(nums[i]);
          }
      }
      int[] result = new int[list.size()];
        int l = 0;
        for(int item : list){
            result[l++] = item;
        }

      return result;
    }
    public static void main(String args[]){
        int[] b = {5,8,9,2,3,3};

        RemoveElement27 s = new RemoveElement27();
        s.removeElement(b,3);
        String l = Arrays.toString(s.removeElement(b,3));
        System.out.println(l);
    }


}
