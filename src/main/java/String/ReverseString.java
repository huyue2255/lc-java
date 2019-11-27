package String;

import java.util.HashSet;

/**
 * Created by yuehu on 10/8/18.
 *
 *String is an immutable.StringBuffer is a mutable and synchronized.
 *StringBuilder is also mutable but its not synchronized.
 */
public class ReverseString {

    public void reverseString(String s) {
        char[] try1 = s.toCharArray();
        for (int i = try1.length - 1; i >= 0; i--) {
            System.out.print(try1[i]);
        }
    }

    public void reverseString1(String s) {
        StringBuilder output = new StringBuilder();
        output.append(s);
        output = output.reverse();
        //System.out.print(output.toString());
    }


    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }


    public static void main(String[] args) {
        String s = "hello";
        ReverseString a = new ReverseString();
//        a.reverseString(s);

        a.reverseString1(s);
        String c = "abababab";

        a.reverse(s);
        System.out.println(a.reverse(s));
//        System.out.println(c.substring(0,4));
//        System.out.println(c.indexOf("ab",0));
        //#2 test
//        System.out.println('a'-'d');
//        StringBuffer sb = new StringBuffer();
//        sb.append("hello");
//        sb.append("World");
//        System.out.println(sb);
//        HashSet<String> set = new HashSet<>();
//        set.add(sb.toString());
//        System.out.println(set.size());

    }
}