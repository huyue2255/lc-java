package Basic;

/**
 * Created by yuehu on 10/1/17.
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        Integer first = null;
        Integer second = null;
        Integer third = null;

        for(int i = 0; i < nums.length; i++){
            if (first == null) {
                first = nums[i];
                continue;
            }
            if (nums[i] == first) {
                continue;
            }
            if(nums[i] > first){
                third = second;
                second = first;
                first = nums[i];
               // System.out.println(third);
                continue;

            }

            if (second == null) {
                second = nums[i];
                continue;
            }

            if (nums[i] == second) {
                continue;
            }
            if(nums[i] > second){
                third = second;
                second = nums[i];
               // System.out.println(third);
                continue;

            }

            if (third == null) {
                third = nums[i];
                continue;
            }

            if (nums[i] == third) {
                continue;
            }
            if(nums[i] > third){
                third = nums[i];
              //  System.out.println(third);
            }
        }

        if(third == null|| second == null) {

            return first;
        }

        return third;
    }

    public static void main(String args[]){
        ThirdMax a = new ThirdMax();
        int[] b = {1,2,-2147483648};
       // int[] b = {};
        System.out.println(a.thirdMax(b));
       // System.out.println(Integer.MIN_VALUE);
    }
}
