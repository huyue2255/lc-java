package String;

import java.util.Arrays;

/**
 * Created by yuehu on 10/12/18.
 *
 * 557
 * Given a string, you need to reverse the order of characters in each word within
 * a sentence while still preserving whitespace and initial word order.
 *
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseStringIII {
    public String  reverseWords(String s) {
        String[] strs = s.split(" ");
        String result = "";
        int n = strs.length;
        for(int i = 0; i < n; i++){
            result += reverse(strs[i])+ " ";
        }
        return result;}

    private String reverse(String str) {
        int j = str.length() - 1;
        String result1 = "";
        while (j >= 0) {
            result1 += str.charAt(j);
            j--;
        }
        return result1;
    }

    public static void main(String[] args){
        ReverseStringIII z = new ReverseStringIII();
        String e = "Hello world grace!";
        z.reverseWords(e);
        System.out.println(z.reverseWords(e));


    }
}
