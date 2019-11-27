package Array;

import java.util.HashSet;

/**
 * Created by yuehu on 5/25/19.
 */
public class DistributeCandies575 {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int candy: candies) {
            set.add(candy);
        }
        return Math.min(set.size(), candies.length / 2);
    }

    public static void main(String[] args) {

    }

    }
