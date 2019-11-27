package Array;

/**
 * Created by yuehu on 10/8/18.
 * {1, 2, 3, 4, 0}
 *           j
 *           i
 */
public class MoveZeros {
    //num of operation : nums.length;
    public void moveZeros2(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int start = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        while(start < nums.length) {
            nums[start++] = 0;
        }
    }
    //num of operation : 2*num of non-zero
    //lots of zeros
    public void moveZeros1(int[] nums) {
        if(nums == null || nums.length == 0) return;
        for(int i =0,j=0;i<nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }


    public static void main(String args[]){
        int[] b = {1, 0, 0, 23, 2};

        MoveZeros s = new MoveZeros();
        s.moveZeros1(b);

        System.out.println(b[0] + " ");
        System.out.println(b[1] + " ");
        System.out.println(b[2] + " ");
        System.out.println(b[3] + " ");
        System.out.println(b[4] + " ");
//        System.out.println(b.length);
//        int count = 0;
//        b[count++] = 12; assign the value and then increase itself
//        System.out.println(b[0] + " ");
//        System.out.println(count);

    }


}
