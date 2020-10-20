package LaiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 10/13/20.
 */
public class CommonElementsII {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Assumptions: a, b c are not null
        List<Integer> common = new ArrayList<Integer>();
        int ai = 0;
        int bi = 0;
        int ci = 0;
        while (ai < a.length && bi < b.length && ci < c.length) {
            if (a[ai] == b[bi] && b[bi] == c[ci]) {
                common.add(a[ai]);
                ai++;
                bi++;
                ci++;
            } else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
                ai++;
            } else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
                bi++;
            } else {
                ci++;
            }
        }
        return common;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1,2,3,4};
        int[] c = {1,2,3,4,5};
        CommonElementsII co = new CommonElementsII();
        System.out.println(co.common(a,b,c));
    }
}
