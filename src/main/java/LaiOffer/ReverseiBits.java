package LaiOffer;

/**
 * Created by yuehu on 7/11/20.
 */
public class ReverseiBits {
    public int reverseI(int num) {
        for (int offset = 0; offset < 16; ++offset) {
            int right = (num >> offset) & 1;
            int left = (num >> (31 - offset)) & 1;
            if (left != right) {
                num ^= (1 << offset);
                num ^= (1 << (31 - offset));
            }
        }
        return num;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i);
//        }

        ReverseiBits b = new ReverseiBits();
        System.out.println(b.reverseI(1));
    }
}
