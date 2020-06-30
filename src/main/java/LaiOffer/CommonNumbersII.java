package LaiOffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuehu on 6/28/20.
 * Q: Find the common numbers between two sorted arrays a[N], b[M], N, M
 *
 */
public class CommonNumbersII {
    // Assumption: there could be duplicated elements in the given arrays.
    // Method 1: two points.
    public List<Integer> commonI(int[] a, int[] b) {
        // Assumption: a, b is not null
        List<Integer> common = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                common.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    // Method 2: use HashMap.
    public List<Integer> commonII(int[] a, int[] b) {
        List<Integer> common = new ArrayList<Integer>();
        HashMap<Integer, Integer> countA = helper(a);
        HashMap<Integer, Integer> countB = helper(b);
        for (Map.Entry<Integer, Integer> entry: countA.entrySet()) {
            Integer ctInB = countB.get(entry.getKey());
            if (ctInB != null) {
                int appear = Math.min(entry.getValue(), ctInB);
                for (int i = 0; i < appear; i++) {
                    common.add(entry.getKey());
                }
            }
        }
        return common;
    }

    private HashMap<Integer, Integer> helper(int[] a) {
        HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
        for (int num : a) {
            Integer ct = countA.get(num);
            if (ct != null) {
                countA.put(num, ct + 1);
            } else {
                countA.put(num, 1);
            }
        }
        return countA;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,4};
        int[] b = {4,4,5,6,7};
        CommonNumbersII s = new CommonNumbersII();
        System.out.println(s.commonII(a, b));
    }
}
