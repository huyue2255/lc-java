package Basic;

import java.util.Arrays;

/**
 * Created by yuehu on 10/10/19.
 */
public class testFinal {
    private final int[] FIELD = {0,1,2,3};
    public void change() {
        FIELD[0] = 12;
        System.out.println(Arrays.toString(FIELD));
    }
    public static void main(String[] args) {
        testFinal a = new testFinal();
        a.change(); //output:[12, 1, 2, 3]
        float x = 4 / 3;
        double y = 7f / 3;
        System.out.println(7f / 3);
        System.out.println(x);

    }
}
