package InterviewQuestion;

/**
 * Created by yuehu on 11/9/19.
 */
public class RecursionReverseString {
    public String reverseString(String str) {
        if(str.isEmpty()) {
            return str;
        } else {
            return reverseString(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(String[] args) {
        String sample = "hello world";
        RecursionReverseString s = new RecursionReverseString();
        String result = s.reverseString(sample);
        System.out.println(result);
    }
}
