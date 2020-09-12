package LaiOffer;

/**
 * Created by yuehu on 9/1/20.
 * 如果是sort也可以，但是时间复杂度就是nlogn
 * Q: Maximum and minimum of an array using minimum number of comparisons
 * Time: O(3n/2)
 */
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        // Assumptions: array is not null & array.length >= 1.
        int n = array.length;
        // indices (x, n - 1 - x) will be paired up, the larger numbers of
        // each pair will be put on the left side, so after comparisons,
        // The left half of the array are the larger values for each pairs,
        // The right half the array are the smaller values for each pairs.
        for (int i = 0; i < n / 2; i++) {
            if (array[i] < array[n - 1 - i]) {
                swap(array, i , n - 1 - i);
            }
        }
        // the largest value should be the largest of the left half
        // the smallest value should be the smallest of the right half
        return new int[]{largest(array, 0, n / 2 - 1), smallest(array, n / 2, n - 1)};
    }

    private int smallest(int[] array, int left, int right) {
        int smallest = array[left];
        for (int i = left + 1; i <= right; i++) {
            smallest = Math.min(smallest, array[i]);
        }
        return smallest;
    }

    private int largest(int[] array, int left, int right) {
        int largest = array[left];
        for (int i = left + 1; i <= right; i++) {
            largest = Math.max(largest, array[i]);
        }
        return largest;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


}
