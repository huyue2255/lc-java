package LaiOffer;

/**
 * Created by yuehu on 11/6/19.
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        int n = 3;
        FibonacciNumber s = new FibonacciNumber();
        System.out.println(s.fib(4));
    }
}
