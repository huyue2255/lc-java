package String;

/**
 * Created by yuehu on 4/22/19.
 * Q:28
 * Implement strStr().

 * Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class  ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length(); i++) {
            //"a" cannot include "=" else will cause error
            if(i + needle.length() > haystack.length()) {
                break;
            }
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                if(j == needle.length() - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "hello";
        String t = "hel";
        ImplementstrStr28 a = new ImplementstrStr28();
        System.out.println(a.strStr(s,t));
    }
}
