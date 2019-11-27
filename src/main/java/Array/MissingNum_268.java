package Array;

/**
 * Created by yuehu on 6/17/19.
 */
public class MissingNum_268 {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] target = {0,1,3};
        MissingNum_268 s = new MissingNum_268();
        System.out.println(s.missingNumber(target));
    }
}
