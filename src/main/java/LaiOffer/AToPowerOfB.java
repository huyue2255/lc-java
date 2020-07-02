package LaiOffer;

/**
 * Created by yuehu on 11/6/19.
 * Time: O(log(n))
 * Space: O(log(n))
 *  a^b
 * 1. 0 as th denominator
 * 2. 1/3 as an integer?? or float
 * 3. 0^0
 * 2^(-10)
 */
public class AToPowerOfB {
    public double power(int a, int b) {
        if (a == 0 && b <= 0) {
            return -1;
        } else if(b < 0) {
            return (double)(1 / pow(a,b));
        } else {
            return (double)pow(a,b);
        }
    }

    private double pow(int a, int b) {
        if (b == 0) {
            return 1;
        }
        double half_result = pow(a, b/2);
        if ( b % 2 == 0) {
            return half_result * half_result;
        } else {
            return half_result * half_result * a;
        }
    }

    public static void main(String[] args) {
        int a = 2;
        int b = -2;
        AToPowerOfB s = new AToPowerOfB();
        System.out.println(s.power(a,b));
    }
}
