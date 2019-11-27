package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yuehu on 4/22/19.
 * Q:88
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *Note:
 *The number of elements initialized in nums1 and nums2 are m and n respectively.
 *You may assume that nums1 has enough space (size that is greater or equal to m + n)
 *to hold additional elements from nums2.
 */
public class MergeSortedArray88 {
//    public void merge(int[] num1, int m, int[] num2, int n) {
//        int i = m-1;
//        int j = n-1;
//        int k = m+n-1;
//
//        while(i >= 0 && j >= 0){
//            num1[k--] = (num1[i] > num2[j] ? num1[i--] : num2[j--]);
//        }
//        while(j >= 0) {
//            num1[k--] = num2[j--];
//        }
//    }

    public int[] merge(int[] num1,int[] num2) {
        int i = num1.length - 1;
        int j = num2.length - 1;
        int k = i+j+1;
        int[] result = new int[i+j+2];

        while(i >= 0 && j >= 0){
            result[k--] = (num1[i] > num2[j] ? num1[i--] : num2[j--]);
        }
        while(j >= 0) {
            result[k--] = num2[j--];
        }

        while(i >= 0) {
            result[k--] = num1[i--];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {1,2,11,12,13,14};
        int[] a = {5,6,7};
        MergeSortedArray88 t = new MergeSortedArray88();
        int[] res = t.merge(s,a);
        System.out.println(Arrays.toString(res));
    }
}
