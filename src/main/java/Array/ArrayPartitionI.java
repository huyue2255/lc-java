package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 10/8/18.
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length - 1; i = i + 2 ){
            sum = sum + nums[i];
        }
        return sum;

    }

    public static void main(String args[]){
        int[] b = {1,2,3,4,5,6};

        ArrayPartitionI s = new ArrayPartitionI();
        s.arrayPairSum(b);
        System.out.println(s.arrayPairSum(b) + " ");

    }
}
