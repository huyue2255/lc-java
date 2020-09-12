package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 8/31/20.
 * Q1: 给定一个排好序的数组，消除里面的重复元素，对于重复元素只保留一个，怎么做。
 * slow: all elements to the left hand side of slow (including slow) are the final result
 *  fast: current index
 */
public class ArrayDeduplicationI {
    public int[] dedup(int[] array) {
        // Assumptions: array is not null.
        if (array.length <= 1) {
            return array;
        }
       // slow pointer starts from 0 and array[0] is always valid.
       // slow pointer is  "include" in the valid partition
        int end = 0;
        for (int i  = 1; i < array.length; i++) {
            if (array[end] != array[i]) {
                array[++end] = array[i];
            }
        }
        return Arrays.copyOf(array, end+1 );
    }

    // * slow: all elements to the left hand side of slow (excluding slow) are the final result
    public int[] dedupI(int[] array) {
        // Assumptions: array is not null.
        if (array.length <= 1) {
            return array;
        }
        // slow pointer starts from 0 and array[0] is always valid.
        // slow pointer is  "include" in the valid partition
        int slow = 1;
        for (int fast  = 1; fast < array.length; fast++) {
            if (array[fast] == array[slow-1]) {
                array[slow++] = array[fast];
            }
        }
        return Arrays.copyOf(array, slow);
    }

    public static void main(String[] args) {



    }

}
