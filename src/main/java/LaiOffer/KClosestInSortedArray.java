package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/10/19.
 */
public class KClosestInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        }
        if (k == 0) {
            return new int[0];
        }

        if (k >= array.length) {
            return array;
        }

        int left = largestSmallerEqual(array,target);
        int right = left + 1;
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            if (right > array.length - 1 || left >= 0 &&
                    target - array[left] <= array[right] - target) {
                result[i] = array[left--];
            } else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    private int largestSmallerEqual(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (array[right] <= target) {
            return right;
        }

        if (array[left] <= target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        KClosestInSortedArray s = new KClosestInSortedArray();
        int[] array = {9,10,12,20,21,22,23};
        System.out.println(Arrays.toString(s.kClosest(array,19,9)));
    }

}
