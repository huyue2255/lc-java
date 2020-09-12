package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 8/31/20.
 * Q1: 给定一个排好序的数组，消除里面的重复元素，对于重复元素只保留两个，怎么做。
 * slow: all elements to the left hand side of slow (including slow) are the final result
 *  fast: current index
 */
public class ArrayDeduplicationII {
    public int[] dedup(int[] array) {
        // Assumptions: array is not null.
        if (array.length <= 2) {
            return array;
        }

        int end = 1;
        for (int i = 2; i < array.length; i++) {
            // Notice: we can do this because it is a sorted array, and
            // array[i] == array[end - 1] implies that
            // array[end - 1] == array[end] == array[i].
            if (array[i] != array[end - 1]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end + 1);
    }


    // slow: all elements to the left hand side of slow (excluding slow) are the final result
    public int[] dedupI(int[] array) {
        // Assumptions: array is not null.
        if (array.length <= 2) {
            return array;
        }

        int end = 2;
        for (int i = 2; i < array.length; i++) {
            // Notice: we can do this because it is a sorted array, and
            // array[i] == array[end - 1] implies that
            // array[end - 1] == array[end] == array[i].
            if (array[i] != array[end - 2]) {
                array[end++] = array[i];
            }
        }
        return Arrays.copyOf(array, end);
    }

}
