package Other;

/**
 * Created by yuehu on 5/30/19.
 */
public class Pow {
    public double myPow1(double x, int n) {
        if(n > 0) {
            return pow(x,n);
        }else {
            return 1 / pow(x,n);
        }
    }

    public double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        double y = pow(x, n/2);
        if(n%2 == 0) {
            return y * y;
        }else {
            return y * y * x;
        }
    }


    public static void main(String[] args) {
        Pow s = new Pow();
        System.out.println(s.myPow1(5,3));
    }
}
