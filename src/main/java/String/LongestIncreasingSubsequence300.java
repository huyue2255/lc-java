package String;

/**
 * Created by yuehu on 5/21/19.
 */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] arr) {

            // 'max' to store the length of longest
            // increasing subarray
            // 'len' to store the lengths of longest
            // increasing subarray at diiferent
            // instants of time
            int max = 1, len = 1;
            // traverse the array from the 2nd element
            for (int i = 1; i < arr.length; i++) {
                // if current element if greater than
                // previous element, then this element
                // helps in building up the previous
                // increasing subarray encountered
                // so far
                if (arr[i] > arr[i - 1])
                    len++;
                else {
                    // check if 'max' length is less
                    // than the length of the current
                    // increasing subarray. If true,
                    // than update 'max'
                    if (max < len)
                        max = len;
                    // reset 'len' to 1 as from this
                    // element again the length of the
                    // new increasing subarray is being
                    // calculated
                    len = 1;
                }
            }
            // comparing the length of the last
            // increasing subarray with 'max'
            if (max < len)
                max = len;

            // required maximum length
            return max;
        }

    public static void main(String[] args) {
        int[] arr = {1,13,6,7,8,9,10};
        LongestIncreasingSubsequence300 s = new LongestIncreasingSubsequence300();
        System.out.println(s.lengthOfLIS(arr));
    }
    }

