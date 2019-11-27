package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/9/19.
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRow) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numRow; i++){
            list.add(0,1);
            for(int j = 1; j < list.size() - 1; j++){
                list.set(j,list.get(j)+list.get(j+1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
