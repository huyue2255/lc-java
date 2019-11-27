package Basic;

/**
 * Created by yuehu on 9/30/17.
 */
public class PlusOne {
    public int[] PlusOne(int[] a) {

        int i = a.length - 1;
        while (i < -1) {
            if (a[i] == 9) {
                a[i] = 0;
            } else {
                a[i] = a[i] + 1;
                return a;
            }
            i--;
        }

        int[] result = new int[a.length + 1];
        result[0] = 1;
        return result;
    }
}