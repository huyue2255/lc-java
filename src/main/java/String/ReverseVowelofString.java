package String;

/**
 * Created by yuehu on 5/16/19.
 * l e o t c e d e
 *       s e
 */
public class ReverseVowelofString {
    public String reverseVoels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] array = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(array[start]) == -1) {
                start++;
            }
            while (start < end && vowels.indexOf(array[end]) == -1) {
                end--;
            }
            char temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ReverseVowelofString a = new ReverseVowelofString();
        System.out.println(a.reverseVoels(s));
    }
}
