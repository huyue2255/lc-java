package Basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 10/2/17.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        if (s.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {
        ContainsDuplicate a = new ContainsDuplicate();
        int[] b = {1};
//        List list = Arrays.asList(b);
//        System.out.println(list.size());
        System.out.println(a.containsDuplicate(b));
    }
}
//
//        if(nums == null || nums.length == 0){
//            return false;
//        }
//
//        if(nums.length == 1){
//            return false;
//        }
//
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length - 1; i++){
//            if(nums[i] == nums[i+1]) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//========================================================
//        Set<Integer> s = new HashSet<Integer>();
//        for(int i = 0; i < nums.length; i++){
//        if(s.contains(nums[i])){
//        return true;
//        }else{
//        s.add(nums[i]);
//        }
//        }
//        return false;
//        }