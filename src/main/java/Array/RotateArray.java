package Array;

/**
 * Created by yuehu on 10/8/18.
 * Given an array, rotate the array to the right by k steps, where k is non-negative.

 Example 1:

 Input: [1,2,3,4,5,6,7] and k = 3
 Output: [5,6,7,1,2,3,4]
 Explanation:
 rotate 1 steps to the right: [7,1,2,3,4,5,6]
 rotate 2 steps to the right: [6,7,1,2,3,4,5]
 rotate 3 steps to the right: [5,6,7,1,2,3,4]
 rotate 4 steps to the right: [4,5,6,7,1,2,3]
 rotate 5 steps to the right: [3,4,5,6,7,1,2]
 rotate 6 steps to the right: [2,3,4,5,6,7,1]
 rotate 7 steps to the right: [1,2,3,4,5,6,7]

 rotate 8 steps to the right: [7,1,2,3,4,5,6]

 */
public class RotateArray {

    public void reverse(int[] nums,int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
//time:O(n) space: O(n)
    //[1,2,3,4,5,6,7]

  //0+8 % 7 = 1;

    public void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            temp[(i+k) % nums.length] = nums[i];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    //time:O(n) space: O(1) 3 times rotated
    //[1,2,3,4,5,6,7]
    //[5,6,7,1,2,3,4]

    // 0+3 % 7 = 3 <= 0
    // 1+3 % 7 = 4 <= 1
    // 2+3 % 7 = 5 <= 2
    // 3+3 % 7 = 6 <= 3
    // 4+3 % 7 = 0 <= 4
    // 5+3 % 7 = 1 <= 5
    // 6+3 % 7 = 2 <= 6

    public void rotate2(int[] nums, int k) {
         k = k % nums.length;
         reverse(nums,0,nums.length-1);
         reverse(nums,0,k-1);
         reverse(nums,k,nums.length-1);
    }


    public void displayArray(int[] nums) {
        for(int i =0 ; i < nums.length ; i++) {
            System.out.println(nums[i] + " ");
        }
    }

    public static void main(String args[]){

        int[] b = {1, 2, 3, 4, 5,6,7};

        RotateArray s = new RotateArray();
//        s.rotate(b,2);
        s.rotate2(b,3);
        s.displayArray(b);

    }
}
