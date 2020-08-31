package LaiOffer;

/**
 * Created by yuehu on 7/8/20.
 * Q: How to determine the number of bits that are different between two positive integers?
 */
public class NumberOfDiffBits {
    public int diffBits(int a, int b) {
        a ^= b;
        int count = 0;
//        for (int i = 0; i < 32; i++) {
//            if (((a >>>= i) & 1) == 1) {
//                count ++;
//            }
//        }
        while (a != 0) {
            count += a & 1;
            a >>>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfDiffBits n = new NumberOfDiffBits();
        System.out.println(n.diffBits(1,9));
    }
}
