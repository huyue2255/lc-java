package LaiOffer;

/**
 * Created by yuehu on 7/12/20.
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Assumptions: the given array is not null
        if (array.length == 0) {
            return 0;
        }
        // dp[i] = 1             ===> array[i] <= array[i-1]
        // dp[i] = dp[i-1] + 1   ===> array[i] > array[i-1]
        // so we can make the space consumption more efficient by only
        // recording the latest dp[i]
        int result = 1;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                cur++;
                result = Math.max(cur,result);
            }else {
                cur = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {7,2,3,1,5,8,9,16};
        LongestAscendingSubArray l = new LongestAscendingSubArray();
        System.out.println(l.longest(array));
    }
}
