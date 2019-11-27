package Other;

/**
 * Created by yuehu on 8/1/19.
 */
public class UniquePaths_62 {
    //time: O(m*n) space:O(m*n)
   public int uniquePath(int m, int n) {
       int[][] res = new int[m][n];

       for(int i = 0; i < m; i++){
           res[i][0] = 1;
       }

       for(int i = 0; i < n; i++){
           res[0][i] = 1;
       }
       for(int i = 1; i < m; i++){
           for(int j = 1; j < n; j++){
               res[i][j] = res[i-1][j] + res[i][j-1];
           }
       }
       return res[m-1][n-1];
   }
    //time: O(m*n) space:O(n)

   public int uniquePath2(int m, int n) {
       int[] res = new int[n];
       res[0] = 1;
       for(int i = 0; i < m; i++) {
           for(int j = 1; j < n; j++){
               res[j] = res[j] + res[j-1];
           }
       }
       return res[n-1];
   }

    public static void main(String[] args) {
        UniquePaths_62 s = new UniquePaths_62();
        System.out.println(s.uniquePath(3,3));
    }
}
