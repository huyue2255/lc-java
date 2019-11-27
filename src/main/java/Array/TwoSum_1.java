package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 7/20/19.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       if(nums == null || nums.length < 2) return null;
       for(int i = 0; i < nums.length; i++){
           map.put(nums[i],i);
       }

       for(int i = 0; i < nums.length; i++){
           if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
               return new int[] {i, map.get(target - nums[i])};
           }
       }
       return null;
    }


    public static void main(String[] args) {
        TwoSum_1 s = new TwoSum_1();
        int[] a = {1,2,4,7};
        System.out.println(Arrays.toString(s.twoSum(a,9)));
    }
}
