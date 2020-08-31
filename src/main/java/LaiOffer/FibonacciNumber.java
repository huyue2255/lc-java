package LaiOffer;

/**
 * Created by yuehu on 11/6/19.
 */
public class FibonacciNumber {
    // recursion Time(2^n)
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fibDp(int n) {
        int[] fibsFound = new int[n+1];
        fibsFound[0] = 0;
        fibsFound[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibsFound[i] = fibsFound[i-1] + fibsFound[i-2];
        }
        return fibsFound[n];
    }

    public static void main(String[] args) {
        int n = 6;
        FibonacciNumber s = new FibonacciNumber();
        System.out.println(s.fibDp(n));
    }
}
