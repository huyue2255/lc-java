package String;

/**
 * Created by yuehu on 4/24/19.
 *Q14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * Example 1:{abc,ab} {abc,abe,abg}
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *TIME: o(m* n*n)
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] str) {
        if(str == null || str.length == 0) {
            return "";
        }

        for(int i = 0; i < str[0].length(); i++) {
            char c = str[0].charAt(i);
            for(int j = 1; j < str.length; j++) {
                if(i == str[j].length() || str[j].charAt(i) != c) {
                    return str[0].substring(0,i);
                }
            }
        }
        return str[0];
    }

    public static void main(String[] args) {
        String[] s = {"ac","a","ab"};
        LongestCommonPrefix14 a = new LongestCommonPrefix14();
        System.out.println(a.longestCommonPrefix(s));

    }

}
