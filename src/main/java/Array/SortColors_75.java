package Array;

/**
 * Created by yuehu on 8/2/19.
 * 75
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library's sort function for this problem.

 * Example:

 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * time: O(n), space: O(1)
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
//        if(nums == null || nums.length == 0) return;
//        int left = 0;
//        int right = nums.length - 1;
//        int index = 0;
//        while(index <= right){
//            if(nums[index] == 0){
//                swap(nums,index++,left++);
//            }else if(nums[index] == 1){
//                index++;
//            }else {
//                swap(nums,index,right--);
//            }
//        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
