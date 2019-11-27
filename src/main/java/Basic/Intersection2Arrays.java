package Basic;

import java.util.*;

/**
 * Created by yuehu on 10/11/17.
 * no：349
 */
public class Intersection2Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet();
        HashSet<Integer> hs2 = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            hs1.add(nums1[i]);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (hs1.contains(nums2[j])) {
                hs2.add(nums2[j]);
            }
        }

        int[] result = new int[hs2.size()];
        int x = 0;
        for(int n : hs2){
            result[x++] = n;
        }

        return result;

    }

    public static void main(String args[]) {
        int[] nums1 = {1, 2, 2, 3};
        int[] nums2 = {2};
        Intersection2Arrays s = new Intersection2Arrays();
        int[] result = s.intersection(nums1, nums2);
        Arrays.toString(result);
        System.out.println(Arrays.toString(result));

    }
}
