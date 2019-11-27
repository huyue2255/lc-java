package Array;

/**
 * Created by yuehu on 7/26/19.
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 * You are given a target value to search. If found in the array return its index, otherwise return -1.

 * You may assume no duplicate exists in the array.

 * Your algorithm's runtime complexity must be in the order of O(log n).
 * Example 1:

 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Time: O(Logn); Space: O(1)
 */
public class SearchingRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = (end - start)/2 + start;
            if(nums[mid] == target) return mid;

            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else {
                    end = mid;
                }

            }
        }

        if(nums[start] == target) {
            return start;
        }

        if(nums[end] == target){
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        SearchingRotatedSortedArray_33 s = new SearchingRotatedSortedArray_33();
        int result = s.search(nums,0);
        System.out.println(result);
    }
}
