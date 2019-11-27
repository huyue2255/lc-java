package Basic;

/**
 * Created by yuehu on 9/26/18.
 */
public class Fibonacci {
    public int fib (int n) {
        if (n <= 1){
            return n;
        } else {
            return fib(n-1) + fib(n-2);
        }

    }

    public static void main (String args[]) {

        Fibonacci f = new Fibonacci();
        int n = 3;
        System.out.println(f.fib(n));
    }
}
