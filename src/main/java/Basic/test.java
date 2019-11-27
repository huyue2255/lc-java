package Basic;

import java.util.Arrays;

/**
 * Created by yuehu on 8/1/19.
 * Write a function which merges two sorted arrays(ascending order) in least time & space complexity.

 */
public class test {
    public void merge (int[] nums1, int[] nums2) {

        int m = nums1.length - nums2.length;
        int n = nums2.length;
        int i = m - 1;
        int j = n - 1;
        int k = m + n -1;
        while(i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] > nums2[j] ? nums1[i--] : nums2[j--]);
        }

        while(j >= 0){
            nums1[k--] = nums2[j--];
        }

    }


    public static void main(String[] args) {

        int[] nums2 = {99,100,109,110,120};
        int[] nums1 = {101,102,103,0,0,0,0};
//        nums1 = [99,100,101,102]. nums2=[1,2,3]
        test s = new test();
        s.merge(nums1,nums2);
        System.out.println(Arrays.toString(nums1));
    }
}
