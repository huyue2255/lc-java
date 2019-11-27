package Array;

/**
 * Created by yuehu on 10/8/18.
 */
public class ReverseArray {
    public void reverse(int[] nums) {
        int temp;
        for(int i = 0; i < nums.length / 2; i++){
            temp = nums[i];
            nums[i] = nums[nums.length-i-1];
            nums[nums.length-i-1] = temp;
        }
    }

    public void displayArray(int[] nums) {
        for(int i =0 ; i < nums.length ; i++) {
            System.out.println(nums[i] + " ");
        }
    }

    public static void main(String args[]){
        int[] b = {1, 3, 5, 23, 2};

        ReverseArray s = new ReverseArray();
        s.reverse(b);

        s.displayArray(b);

    }
}


