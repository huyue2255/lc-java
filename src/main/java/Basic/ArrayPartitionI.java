package Basic; /**
 * Created by yuehu on 10/2/17.
 */
import java.util.Arrays;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i = i + 2){
            sum = sum + nums[i];
        }
        return sum;

    }


    public static void main(String args[]){
        ArrayPartitionI a = new ArrayPartitionI();
        int[] b = {1,6,5,3,4,3};
        System.out.println(a.arrayPairSum(b));

    }
}
