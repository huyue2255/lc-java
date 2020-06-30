package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 6/29/20.
 * Q: Char de-duplication adjacent letters repeatedly
 */
public class RemoveDuplicateIV {
    public String deDup(String input) {
        if (input == null || input.length() < 1) {
            return null;
        }
        // try to convert the string to char[], and do it in-place.
        char[] array = input.toCharArray();
        // instead of using a extra stack explicitly, we can actually
        // reuse the left side of the original char[] as the "stack".
        // end: is where the top of the stack is.
        int end = 0;
        for (int i = 1; i < array.length; i++) {
            System.out.println("length: " + array.length);
            System.out.println("i forssss: " + i);
            // if the stack is empty(when end == -1) or there is no duplicate chars,
            // we are able to push the character into the stack.
            if (end == -1 || array[i] != array[end]) {
                array[++end] = array[i];
            } else {
                // otherwise, we need pop the top element by end--
                // and ignore all the consecutive duplicate chars.
                end--;
                while (i + 1 < array.length && array[i] == array[i + 1] ) {
                    System.out.println("array[i+1]: " + (i+1));
                    i++;
                }
                System.out.println("i else" + i);
            }
            System.out.println("i else: " + i);
        }
        return new String(array,0, end + 1);
    }

    public static void main(String[] args) {
        RemoveDuplicateIV r = new RemoveDuplicateIV();
        String input = "aaaa";
        System.out.println(r.deDup(input));

    }
}
