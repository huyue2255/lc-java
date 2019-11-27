package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 8/12/19.
 */
public class SingleNumber_137 {
    //solution 1
//     public int singleNumber(int[] nums) {
//     HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
//     table.put(nums[0], 1);

    //     int temp =0;
//     for(int i =1; i<nums.length; i++){
//         if(table.containsKey(nums[i])){
//             table.put(nums[i],table.get(nums[i])+1);
//         }else{
//             table.put(nums[i],1);
//         }
//     }
//     for(int i=0; i<nums.length; i++){
//         if(table.get(nums[i])==1){
//             temp = nums[i];
//         }
//     }
//     return temp;
//     }



    //solution 2
//    public int singleNumber2(int[] nums) {
//
//        Set<Integer> a = new HashSet<>();
//        Set<Integer> b = new HashSet<>();
//
//        //Example nums : {1,1,2,3,3}
//        for(int i: nums) {
//            // If can't be added in set a , add integer in set b
//            if(!a.add(i)) {
//                b.add(i);
//            }
//        }
//        // At this point A will have = {1,2,3}
//        // B will have = {1,3}
//        for(int i: a) {
//            if(b.add(i)) {
//                //Intersection
//                return i;
//            }
//        }
//        return -1;
//    }
    //solution 3
    public int singleNumber3(int[] nums) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i : nums) {
            if (!a.add(i)) {
                b.add(i);
            }
        }

        for (int i : a) {
            if(b.add(i)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,2,2};
        SingleNumber_137 s = new SingleNumber_137();
        System.out.println(s.singleNumber3(nums));
    }
}
