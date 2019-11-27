package Array;

import java.util.List;

/**
 * Created by yuehu on 5/20/19.
 */
public class FindPairOfInteger {
    public void findPair(int[] arr, int sum) {
        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == sum) {
                    System.out.println(arr[i]+"and"+arr[j]);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        FindPairOfInteger s = new FindPairOfInteger();
        int[] arr = { 1, 5, 7, -1, 5 };
        s.findPair(arr,6);
    }
}
