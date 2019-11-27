package Basic;

/**
 * Created by yuehu on 10/22/17.
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {


        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < n; j++) {
            for (int i = 1; i < m; i++) {
                dp[j][i] = dp[j - 1][i] + dp[j][i - 1];
            }
        }


        return dp[n-1][m-1];
    }


    public static void main(String args[]){
        UniquePaths s = new UniquePaths();
        System.out.println(s.uniquePaths(6,3));
    }
}
