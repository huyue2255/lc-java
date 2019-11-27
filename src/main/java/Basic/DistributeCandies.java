package Basic;

import java.util.*;

/**
 * Created by yuehu on 10/13/17.
 * no:575
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int result;
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> hm1 = new HashMap<>();

        for (int i = 0; i < candies.length; i++) {
            if (hm1.containsKey(candies[i])) {
                hm1.put(candies[i], hm1.get(candies[i]) + 1);
            } else {
                hm1.put(candies[i], 1);
            }
        }

        set = hm1.keySet();
        result = Math.min(set.size(),candies.length / 2);
        return result;
    }

    public static void main(String args[]) {
        int[] candies = {1,2,2,2,4,4};
        DistributeCandies s = new DistributeCandies();
        System.out.println(s.distributeCandies(candies));
    }
}
