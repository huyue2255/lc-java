package Basic;

import java.util.*;

/**
 * Created by yuehu on 10/11/17.
 */
public class Intersection2ArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {

//            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//            for(int i=0;i<nums1.length;i++)
//                if(map.containsKey(nums1[i])==false)
//                    map.put(nums1[i],1);
//                else
//                    map.put(nums1[i],1+map.get(nums1[i]));
//            List<Integer> resultList = new ArrayList<Integer>();
//            for (int i=0;i<nums2.length;i++)
//                if(map.containsKey(nums2[i])){
//                    if(map.get(nums2[i])>0){
//                        resultList.add(nums2[i]);
//                        map.put(nums2[i],-1+map.get(nums2[i]));
//                    }
//                }
//            int result[] = new int[resultList.size()];
//            for(int i=0;i<resultList.size();i++)
//                result[i]=resultList.get(i);
//            return result;
//
//    }

        HashMap<Integer,Integer> hm1 = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if(hm1.containsKey(nums1[i])){
                hm1.put(nums1[i],hm1.get(nums1[i]) + 1);
            }else {
                hm1.put(nums1[i], 1);
            }
        }

        for (int j = 0; j < nums2.length; j++) {
            if (hm1.containsKey(nums2[j])) {
                if (hm1.get(nums2[j]) > 0) {
                    arrayList.add(nums2[j]);
                    hm1.put(nums2[j], -1 + hm1.get(nums2[j]));
                }
            }
        }
            int[] result = new int[arrayList.size()];
            int x = 0;
            for (int n : arrayList) {
                result[x++] = n;
            }

            return result;
        }

    public static void main(String args[]) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,2};
        Intersection2ArraysII s = new Intersection2ArraysII();
        int[] result = s.intersect(nums1, nums2);
        Arrays.toString(result);
        System.out.println(Arrays.toString(result));

    }
}
