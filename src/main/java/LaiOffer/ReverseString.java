package LaiOffer;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by yuehu on 6/30/20.
 */
public class ReverseString {
    // Method 1
    public String reverseI(String input) {
        if (input == null || input.length() < 0) {
            return input;
        }
        char[] array = input.toCharArray();
        for (int left = 0, right = array.length - 1; left < right; left++, right--) {
            char temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
        return new String(array);
    }

    // Method 2
    // base case: when their are 1 or 0 letters remaining
    // recursive rule: reverse(i+1, j-1)
    public void reverseHelper(char[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(array, left, right);
        reverseHelper(array, left + 1, right - 1);
    }

    public String reverseII(String input) {
        char[] array = input.toCharArray();
        int right = array.length - 1;
        reverseHelper(array, 0, right);
        return new String(array);
    }

    private void swap(char[] array, int right, int left) {
        char temp = array[right];
        array[right] = array[left];
        array[left] = temp;
    }

    public static void main(String[] args) {
        String input = "hello";
        ReverseString s = new ReverseString();
        System.out.println(s.reverseII(input));
    }
}
