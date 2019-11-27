package Linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 6/11/19.
 * 118. Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0,1);
            for(int j = 1; j < list.size() - 1;j++) {
                list.add(j,list.get(j)+list.get(j+1));
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}
