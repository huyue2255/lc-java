package String;

import java.util.Arrays;

/**
 * Created by yuehu on 4/24/19.
 */
public class ReverseString344 {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        int left = 0;
        int right = s.length() - 1;
        char[] str = s.toCharArray();
        while(left < right) {
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
        return new String(str);
//        return Arrays.toString(str);
    }

    public static void main(String[] args) {
        String s = "aaaavvvf";
        ReverseString344 a = new ReverseString344();
        a.reverseString(s);
        System.out.println(a.reverseString(s));
    }

}
