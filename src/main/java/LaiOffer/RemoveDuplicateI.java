package LaiOffer;

/**
 * Created by yuehu on 6/29/20.
 */
public class RemoveDuplicateI {
    // try to convert the input to char[],
    // and do it in place
    public String deDup(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (i ==0 || array[i] != array[end - 1]) {
                array[end++] = array[i];
            }
        }
        return new String(array, 0, end);
    }

    public static void main(String[] args) {
        String input = "aaabbbbbaaaa"; // output: "aba"   advance is output is "ab"
        RemoveDuplicateI r = new RemoveDuplicateI();
        System.out.println(r.deDup(input));
    }

}
