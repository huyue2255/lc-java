package LaiOffer;

/**
 * Created by yuehu on 11/10/19.
 * int[] array = null; 数组为空，此时array不指向任何对象；
 * int[] array = new array[0]; 定义一个长度为0的数组；
 */
public class LastOccurrence {
    public int lastOccurrence(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (array[right] == target) {
            return right;
        } else if (array[left] == target) {
            return left;
        }
        return -1;
    }
    public static void main(String[] args) {
        LastOccurrence s = new LastOccurrence();
        int[] array = {4,4,5,5,5,5,5,12};
        System.out.println(s.lastOccurrence(array,5));
    }
}
