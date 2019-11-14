package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/9/19.
 */
public class RainbowSortII {
    public String rainbowSortII(String target) {
        char[] targetList = target.toCharArray();
        int a = 0;
        int b = 0;
        int c = targetList.length - 1;
        while (b <= c) {
            if (targetList[b] == 'a') {
                swap(targetList,a++, b++);
            } else if (targetList[b] == 'b') {
                b++;
            } else {
                swap(targetList,b,c--);
            }
        }
        return Arrays.toString(targetList);
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public static void main(String[] args) {
        String target = "aaaabcabcabc";
        RainbowSortII s = new RainbowSortII();
        System.out.println(s.rainbowSortII(target));
    }

}
