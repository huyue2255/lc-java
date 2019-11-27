package Other;

/**
 * Created by yuehu on 7/2/19.
 * 16:      10000
 * 16-1:    01111
 */
public class PowOfTwo {
    public boolean isPowerOfTwo(int n) {
        int i=0;
        double ans=0;
        while(ans<=n){
            ans = Math.pow(2,i);
            i++;
            if(ans==(double)n){
                return true;
            }
        }
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        return n > 0 && ((n & (n-1)) == 0);
    }
}
