package String;

/**
 * Created by yuehu on 4/24/19.
 * 58. Length of Last Word
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord58 {
    public int lengthOfLastWord(String strs) {
        String[] strings = strs.split(" ");
        if(strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        String s = "hello world grace hu";
        LengthOfLastWord58 a = new LengthOfLastWord58();
        System.out.println(a.lengthOfLastWord(s));
    }
}
