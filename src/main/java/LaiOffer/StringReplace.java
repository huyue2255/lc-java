package LaiOffer;

/**
 * Created by yuehu on 6/30/20.
 * The java.lang.String.indexOf(String str) method returns the index within this string
 * of the first occurrence of the specified substring. The integer returned is the smallest
 * value k such that: this.startsWith(str, k) is true.
 */
public class StringReplace {
    // Method 2: Using Java's string Builder untility and String's indexof(),
    // not using String's replace();
    public String replaceII(String input, String s, String t) {
        StringBuilder sb = new StringBuilder();
        int fromIndex = 0;
        int matchIndex = input.indexOf(s, fromIndex);
        while (matchIndex != -1) {
            sb.append(input, fromIndex, matchIndex).append(t);
            fromIndex = matchIndex + s.length();
            matchIndex = input.indexOf(s, fromIndex);
        }
        sb.append(input, fromIndex, input.length());
        return sb.toString();
    }

    public static void main(String[] args) {
        String target = "hllelloo";
        String s = "ll";
        String t = "LL";
        StringReplace test = new StringReplace();
        System.out.println(test.replaceII(target, s, t));
    }
}
