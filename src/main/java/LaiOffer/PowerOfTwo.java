package LaiOffer;

/**
 * Created by yuehu on 7/8/20.
 * 二进制 Determine if A number Is Power of 2
 * xor: 相同为0，不同为1
 */
public class PowerOfTwo {
    // Method 1.
    public boolean isPowerOfTwoI(int number) {
       if (number <= 0) {
           return false;
       }
       // ignore all the trailing 0's,
        while ((number & 1) == 0) {
            System.out.println("number: " + number);
           number >>>= 1;
        }
        System.out.println("number outside: " + number);
        return number == 1;
    }

    // Method 2
    public boolean isPowerOfTwoII(int number) {
        if (number < 0) {
            return false;
        }
        // count the number of 1's
        int count = 0;
        while (number > 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count == 1;
    }

    // Method 3
    public boolean isPowerOfTwoIII(int number) {
        return number > 0 && (number & (number -1)) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo n = new PowerOfTwo();
        System.out.println(n.isPowerOfTwoII(8));
    }
}
