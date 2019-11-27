package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 7/26/19.
 */
public class SearchforaRange_34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int start = findFirst(nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }
        int end = findLast(nums, target);
        return new int[]{start, end};
    }

    public int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

    public int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

    public static void main(String[] args) {
        SearchforaRange_34 s = new SearchforaRange_34();
        int[] a = {5,7,7,8,8,9};
        System.out.println(Arrays.toString(s.searchRange(a,8)));
    }
}
