package LaiOffer;

/**
 * Created by yuehu on 11/9/19.
 */
public class BinarySearch {
    // iterative left <= right
    public int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // iterative <
    public int binarySearchII(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) { // [left ,right)
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) { // [mid + 1, right)
                left = mid + 1;
            } else {              // [left, mid)
                right = mid;
            }
        }
        return -1;
    }

    // iterative left +1 < right
    public int binarySearchIII(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) { // [left ,right]
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) { // [left, mid]
                right = mid;
            } else if (target > nums[mid]) { // [mid, right]
                left = mid;
            } else {
                return mid;
            }
        }

        if (target == nums[left]) {
            return left;
        } else if (target == nums[right]) {
            return right;
        }
        return -1;
    }

    // recursion
    public int binarySearchI(int[] nums, int low, int high, int target) {
        if (high <= low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (nums[mid] < target) {
            return binarySearchI(nums, mid+1, high,target);
        } else if (nums[mid] > target) {
            return binarySearchI(nums,low,mid-1,target);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        BinarySearch s = new BinarySearch();
        int[] a = {1,3,4,5,0,2,12,10};
//        System.out.println(s.binarySearchI(a,0,7,101));
        System.out.println(s.binarySearchIII(a,30));

    }

}
