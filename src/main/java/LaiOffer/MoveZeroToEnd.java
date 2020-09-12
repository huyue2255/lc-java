package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/6/19.
 * move 0s to the right end of the arrayno need to keep
 * the relative order of the elements in original array
 */
public class MoveZeroToEnd {
    public int[] moveZeroI(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            if (array[left] != 0) {
                left++;
            } else if (array[right] == 0) {
                right--;
            } else {
                swap(array,left++,right--);
            }
        }
        return array;
    }

    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    public void moveZeroeII(int[] nums) {
        int count= 0;
        for(int i = 0; i <nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }

        while(nums.length - count > 0) {
            nums[count++] = 0;
        }

    }

    public void moveZeroeIII(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            } else {
                fast++;
            }
        }
        while (slow < nums.length) {
            nums[slow++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] array = {1,0,4,5,0,0,4,4,4,0,0,};
        MoveZeroToEnd s = new MoveZeroToEnd();
        s.moveZeroeIII(array);
        System.out.println(Arrays.toString(array));
    }

}
