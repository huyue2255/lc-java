package Basic;

/**
 * Created by yuehu on 10/22/17.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int x = 1;
        int y = 2;
        int z = 0;

        if (n == 1 || n == 2) {
            return n;
        }

        for (int i = 0; i < n -2; i++) {
            z = x + y;
            x = y;
            y = z;
        }
        return  z;
    }


    public static void main(String args[]){
        ClimbingStairs s = new ClimbingStairs();
        System.out.println(s.climbStairs(4));


    }
}
