package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by yuehu on 4/19/19.
 * Q:287
 *{1,2,2,3,4,5};
 MIN: 0, MAX:5 mid: 2
 count: 3 max: 1

 max : 1 mid: 0 min : 1

 min : 1 mid : 1  min : 2

 *
 */
public class FintheDuplicateNumber287 {
//    public int findDuplicate1(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums.length; i++) {
//            if(set.contains(nums[i])) {
//                return nums[i];
//            }else {
//                set.add(nums[i]);
//            }
//        }
//        return 0;
//    }
    public int findDuplicate(int[] nums) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max) {
            int mid = (max - min) / 2 + min;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                max = mid - 1;
                System.out.println("max"+max);
            } else {
                min = mid + 1;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        FintheDuplicateNumber287 d = new FintheDuplicateNumber287();
        int[] arr = {1,2,2,3,4};
        int[] arr1 = {1,2,3,5,5,4};
        System.out.println(d.findDuplicate(arr1));
    }
}
