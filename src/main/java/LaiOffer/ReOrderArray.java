package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 6/30/20.
 * ABCD1234 - > A1B2C3D4
 */
public class ReOrderArray {
    public int[] reorder(int[] array) {
        // Assumption: array is not null.
        if (array.length % 2 == 0) {
            reorder(array, 0, array.length - 1);
        } else {
            // if array has odd number of elements, e ignore the last one
            // when do the reordering
            reorder(array, 0, array.length - 2);
        }
        return array;
    }

    private void reorder(int[] array, int left, int right) {
        int length = right - left + 1;
        // if the subarray has 2 or 0 elements, we can just return
        // as this should be the base case
        if (length <= 2) {
            return;
        }

        // calculate the important mid points:
        // index: 0 1 2 3 4 5 6 | 7 8 9 0 1 2 3
        //        A B C D E F G | 1 2 3 4 5 6 7
        //              lm        m     rm
        // size = 14
        //lm = left + 1/4 * size = 3
        // m = left + 1/2 * size = 7
        // rm = left + 3/4 * size = 10

        int mid = left + length / 2;
        int lmid = left + length / 4;
        int rmid = left + length * 3 / 4;
        reverse(array, lmid, mid - 1);
        reverse(array, mid, rmid - 1);
        reverse(array, lmid, rmid - 1);
        // half of the left partition's size = lmid - left;
        reorder(array, left, left + (lmid - left) * 2 - 1);
        reorder(array, left + (lmid - left) * 2, right);
    }

    private void reverse(int[] array, int left, int right) {
        while  (left < right){
            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReOrderArray r = new ReOrderArray();
        int[] test = {1,2,3,4,5,6,7,8,9,10};
        int[] result = r.reorder(test);
        System.out.println(Arrays.toString(result));
    }


}
