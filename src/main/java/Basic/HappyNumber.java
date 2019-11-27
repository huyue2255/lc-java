package Basic;

import java.util.HashSet;

/**
 * Created by yuehu on 10/14/17.
 * no:202
 * Math.pow(num%10, 2);
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        HashSet<Integer> hs = new HashSet<>();
        while (true) {
            int help = help(n);
            if (help == 1) {
                return true;
            } else {
                if (hs.contains(help)) {
                    return false;
                }
                hs.add(help);
                n = help;
            }
        }
    }


    public int help(int n) {
        int result = 0;
        while (n > 0) {
            result += (n % 10) * (n % 10);
            n = n / 10;
        }
        return result;
    }


    public static void main(String args[]){
        int num = 19;
        HappyNumber s = new HappyNumber();
        System.out.println(s.isHappy(num));
    }
}
