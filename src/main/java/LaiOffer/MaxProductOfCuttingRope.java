package LaiOffer;

/**
 * Created by yuehu on 7/12/20.
 * Q: Given a rope with integer-length n, how to cut the rope into M integer-length parts with length
 * p[0], p[1], ..., p[m-1], in order to get the maximal product of p[0]*p[1]*...*p[m-1]
 * solution1: 左大段，右大段
 * solution1: 左大段，右小段
 * 大段的意思： 我们需要读表格， 获取m[left] 的数值
 * 小段的意思： 我们不需要读表格，而是不需要做任何cut,自成一段绳子
 * input: 1m 2m
 * induction rule: represents maximal product of a rope with i-meter long (at least one cut must be made)
 */
public class MaxProductOfCuttingRope {
    // DP
    public int maxProduct(int length) {
        // Assumptions: length >= 2
        if (length == 2) {
            return 1;
        }
        int[] array = new int[length + 1];
        array[1] = 0;
        array[2] = 1;
        for (int i = 3; i < array.length; i++) {
            // At least one of the partitions after cutting is <= i/2,
            // so we can just pick that partition, and find the maxmum product.
            for (int j = 1; j <= i / 2; j++) {
                // For the other partition, we can choose not cutting it or
                // cutting it, so the max number we can get is either i-j or array[i-j]
                array[i] = Math.max(array[i], j * Math.max(array[i-j], i-j));
            }
        }
            return array[length];
    }

    // Non-DP, can we do it with Recursion
    // 1. Base case size = 1m
    // 2. Recursion rule: Product[i]
    public int getMaxProduct(int n) {
        if (n <= 1) {
            return 0; // base case
        }

        int maxProduct = 0;
        for (int i = 1; i < n; i++) { // i = meters of rope as 右小段
            int best = Math.max(n - i, getMaxProduct(n - i));
            // (no cut) rope remains, cut == subproblem
            maxProduct = Math.max(maxProduct, i * best);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaxProductOfCuttingRope s = new MaxProductOfCuttingRope();
        System.out.println(s.getMaxProduct(5));
    }

}
