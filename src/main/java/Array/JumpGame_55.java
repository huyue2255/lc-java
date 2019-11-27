package Array;

/**
 * Created by yuehu on 7/31/19.
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > max) return false;
            max = Math.max(nums[i] + i, max);
        }

        return true;
    }
}
