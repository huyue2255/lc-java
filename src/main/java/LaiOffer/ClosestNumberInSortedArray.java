package LaiOffer;

/**
 * Created by yuehu on 11/10/19.
 */
public class ClosestNumberInSortedArray {

    public int closestNumberInSortedArray(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
            while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(array[right] - target) < Math.abs(array[left] - target)) {
            return right;
        } else {
            return left;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,6,7,8};
        ClosestNumberInSortedArray s = new ClosestNumberInSortedArray();
        System.out.println(s.closestNumberInSortedArray(array,4));
    }
}
