package Basic;

/**
 * Created by yuehu on 9/25/18.
 */
public class LengthOfLongestArray {

    public int findLengththOfLCIS (int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; i++){
            if(i>0 && nums[i-1] >= nums[i]) {
                anchor = i;
            }

            ans = Math.max(ans, i- anchor +1);
        }

        return ans;
    }

    public static void main(String args[]) {
        LengthOfLongestArray s = new LengthOfLongestArray();
        int[] a = {11, 2, 3, 4, 23, 45, 55, 77};
        System.out.println(s.findLengththOfLCIS(a));
    }

}
