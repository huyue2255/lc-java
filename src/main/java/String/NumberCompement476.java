package String;

/**
 * Created by yuehu on 5/26/19.
 * 476. Number Complement
 */
public class NumberCompement476 {
    public int findComplement(int num) {
        int sum = 0;
        while(sum < num) {
            sum = (sum << 1) | 1;
        }
        return sum - num;
    }

    public static void main(String[] args) {
        int num = 5;
        NumberCompement476 s = new NumberCompement476();
        System.out.println(s.findComplement(num));
    }

}
