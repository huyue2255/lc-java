package LaiOffer_Java;

import java.util.Arrays;

/**
 * Created by yuehu on 8/19/19.
 * if have the target find the target then find the largest number smaller than target
 * expand from the target place == 中心开花
 * time: log(n) + k
 */
public class KthCloseNumberInSortedArray {
    public int[] kClosest(int[] array, int target, int k) {
        if (array == null || array.length == 0) {
            return array;
        }

        if (k == 0) {
            return new int[0];
        }

        if(array.length < k) {
            return array;
        }
        //left is the largest smaller or equal element
        //right = left + 1;
        //these two should be the closest to target
        int left = largestSmallerEqual(array, target);
        int right = left + 1;
        int[] result = new int[k];

        //this is a typical merge operation
        for (int i = 0; i < k; i++) {
            //we can advance the left pointer when:
            //1. right pointer is already out of bound
            //2. right pointer is not out of bound, left pointer is not out of bound,
            //   and array[left] is closer to target
            if(right >= array.length || left >= 0 &&
                    target - array[left] <= array[right] - target) {
                result[i] = array[left--];
            }else {
                result[i] = array[right++];
            }
        }
        return result;
    }

    private int largestSmallerEqual(int[] array, int target) {
        //find the largest smaller or equal element's index in the array
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] <= target) {
                left = mid;
            }else {
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
        KthCloseNumberInSortedArray s = new KthCloseNumberInSortedArray();
        int[] arr = {2};
        int[] result = s.kClosest(arr,2,4);
        System.out.println(Arrays.toString(result));
    }
}
