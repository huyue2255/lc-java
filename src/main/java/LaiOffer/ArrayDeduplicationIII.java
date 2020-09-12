package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 8/31/20.
 * Q1: 给定一个排好序的数组，消除里面的重复元素，对于重复元素一个都不保留，怎么做。
 * slow: all elements to the left hand side of slow (not including slow) are the final result
 *  fast: current index
 */
public class ArrayDeduplicationIII {
    public int[] dedup(int[] array) {
        int fast = 0;
        int slow = 0;


        while (fast < array.length) {
            int begin = fast;
            while (fast < array.length && array[fast] == array[begin]) {
                fast++;
            }
            if (fast - begin == 1) {
                array[slow++] = array[begin];
            }
        }
        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {
        int[] test = {1,1,2,2,3};
        ArrayDeduplicationIII s = new ArrayDeduplicationIII();
        System.out.println(Arrays.toString(s.dedup(test)));
    }

}
