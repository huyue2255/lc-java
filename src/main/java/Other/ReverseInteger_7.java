package Other;


import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by yuehu on 7/22/19.
 * 7. Reverse Integer
 *  Time: O(n)
 *  Space:O(1)
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        long res = 0;
        while( x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int)res;
    }
    public static void main(String[] args) {
         int x = 10;
        ReverseInteger_7 s = new ReverseInteger_7();
        System.out.println(s.reverse(x));
    }
}
