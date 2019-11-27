package String;

/**
 * Created by yuehu on 8/6/19.
 */
public class DecodeWays_91 {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= len; i++) {
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }

            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "1231";
        DecodeWays_91 a = new DecodeWays_91();
        System.out.println(a.numDecodings(s));
    }
}
