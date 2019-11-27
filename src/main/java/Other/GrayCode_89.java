package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/6/19.
 */
public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < 1 << n;i++) {
            res.add(i ^ i >> 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 2;
        GrayCode_89 s = new GrayCode_89();
        System.out.println(s.grayCode(3));
    }
}
