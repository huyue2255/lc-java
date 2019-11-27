package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 3/29/19.
 */
public class ContainsDup217 {
    public boolean containsDup(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(s.contains(nums[i])) {
                return true;
            } else {
                s.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[] b = {1,2,3,4,5,6,7};

        ContainsDup217 s = new ContainsDup217();
        boolean result = s.containsDup(b);
        System.out.println(result);

    }
}
