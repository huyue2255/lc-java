package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/2/19.
 */
public class MergeSort {
    public int[] mergeSort(int[] array) {
        //check null array first
        if (array == null) {
            return array;
        }

        int[] helper = new int[array.length];
        mergeSort(array,helper,0,array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array,helper,left,mid);
        mergeSort(array,helper,mid+1,right);
        merge(array,helper,left,mid,right);
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
       for (int i = 0; i <= right; i++) {
           helper[i] = array[i];
       }

       int leftIndex = left;
       int rightIndex = mid + 1;
       while (leftIndex <= mid && rightIndex <= right) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
       }
        while (leftIndex <= mid) {
           array[left++] = helper[leftIndex++];
        }
    }


    public static void main(String[] args) {
        MergeSort solution = new MergeSort();
        int[] array = {1,3,6,2,0};
        int[] result = solution.mergeSort(array);
        System.out.println(Arrays.toString(result));
    }
}
