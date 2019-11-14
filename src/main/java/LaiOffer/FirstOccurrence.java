package LaiOffer;

/**
 * Created by yuehu on 11/10/19.
 */
public class FirstOccurrence {
    public int firstOccurrence(int[] array,int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (array[left] == target) {
            return left;
        } else if (array[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstOccurrence s = new FirstOccurrence();
        int[] array = {4,4,5,5,5,5,5,12};
        System.out.println(s.firstOccurrence(array,5));
    }
}
