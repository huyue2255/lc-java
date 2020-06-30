package LaiOffer;

/**
 * Created by yuehu on 6/30/20.
 * Q: shift whole string to the right-hand side by two positions.
 * abcdef => fe abcd
 */
public class RightShift {
    // Assumption: input is no null, n >= 0.
    public String rightShift(String input, int n) {
        if (input.length() <= 1) {
            return input;
        }
        char[] array = input.toCharArray();
        n %= array.length;
        reverse(array, array.length - n, array.length - 1);
        reverse(array, 0, array.length - n - 1);
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int a, int b) {
        while(a < b) {
            char tmp = array[b];
            array[b] = array[a];
            array[a] = tmp;
            a++;
            b--;
        }
    }

    public static void main(String[] args) {
        RightShift r = new RightShift();
        String test = "hellograce";
        System.out.println(r.rightShift(test, 5));
    }
}
