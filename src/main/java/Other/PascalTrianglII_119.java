package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/9/19.
 */
public class PascalTrianglII_119 {
    public List<Integer> gerRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0) return res;
        for(int i = 0; i < rowIndex + 1; i++){
            res.add(0,1);
            for(int j = 1; j < res.size() - 1; j++) {
                res.set(j,res.get(j) + res.get(j+1));
            }
        }
        return res;
    }
}
