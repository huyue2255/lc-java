package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 10/8/18.
 * List can contain duplicate elements whereas Set contains unique elements only.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
     Set<Integer> set = new HashSet<>();
     for(int i = 0; i < nums.length; i++) {
         if(set.contains(nums[i])){
             return true;
         }else {
             set.add(nums[i]);
         }
     }
        return false;
    }


    public static void main(String args[]){
        int[] b = {1, 0, 5, 23, 2};

        ContainsDuplicate s = new ContainsDuplicate();
        s.containsDuplicate(b);

        System.out.println(s.containsDuplicate(b));


    }
}


//    public boolean containsDuplicate(int[] nums) {
//        Set<Integer> s = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//            if(s.contains(nums[i])){
//                return true;
//            }else {
//                s.add(nums[i]);
//            }
//        }
//        return false;
//    }