package LaiOffer;

/**
 * Created by yuehu on 11/6/19.
 * Time: O(log(n))
 * Space: O(log(n))
 */
public class AToPowerOfB {
    public int a_pow_b(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int half = a_pow_b(a, b / 2);
        if (b % 2 == 0) {
            return half * half;
        } else {
            return half * half * a;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        AToPowerOfB s = new AToPowerOfB();
        System.out.println(s.a_pow_b(a,b));
    }
}
