package Array;

import java.util.Arrays;

/**
 * Created by yuehu on 11/19/18.
 */
public class CopyArray {
    public static void main(String[] args) {
        int array[] = { 1, 2, 3, 4, 5 };
        int[] copy = Arrays.copyOf(array, 5);
        System.out.println();
        for(int c: copy){
            System.out.println(c);
        }
    }
}
