import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuehu on 9/15/17.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target-nums[i]) != i) {
                return new int[] {i, map.get(target-nums[i])};
            }
        }

        return null;
    }

    @Test
    public void t1() {
        TwoSum solution = new TwoSum();
        int[] arr = new int[] {2,7,11,5};
        int target = 9;
        Gson gson = new Gson();
        String s = gson.toJson(solution.twoSum(arr, target));
        System.out.println(s);
    }
}
