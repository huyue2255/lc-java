package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by yuehu on 5/30/19.
 */
public class IntersectionOfTwoArray349 {
//binary search
//    public int[] intersection2(int[] nums1, int[] nums2) {
//
//    }

    //time: O(n) space: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {
         if(nums1 == null || nums1.length == 0 || nums2 == null || nums1.length == 0) {
             return new int[]{};
         }

         HashSet<Integer> set = new HashSet<>();
         HashSet<Integer> ret = new HashSet<>();

        for(int num: nums1){
            set.add(num);
        }

        for(Integer num2: nums2){
            if(set.contains(num2)){
                ret.add(num2);
            }
        }
        int l = 0;

        int[] res = new int[ret.size()];
        for(Integer item: ret){
            res[l++] = item;
        }

        return res;
    }

    //Arrays.sort time: O(nlogn) space: O(n)
    public int[] intersection1(int[] nums1, int[] nums2) {
        HashSet<Integer> h = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                h.add(nums1[i]);
                j++;
                i++;
            }
        }
        //copy all value from arraylist to array
        int[] a = new int[h.size()];
        int l =0;
        for(Integer item:h){
            a[l++]=item;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] s = {1,2,3,4,5,8,8};
        int[] e = {8,8,8,8,1,2,3,4,5};
        IntersectionOfTwoArray349 w = new IntersectionOfTwoArray349();
        String r = Arrays.toString(w.intersection1(s,e));
        System.out.println(r);
    }
}


