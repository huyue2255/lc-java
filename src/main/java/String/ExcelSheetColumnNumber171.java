package String;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by yuehu on 5/1/19.
 * 171. Excel Sheet Column Number
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28
 ...

 */
public class ExcelSheetColumnNumber171 {
    public int titileNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            res = res*26 + (s.charAt(i) - 'A'+ 1);
        }
        return res;
    }
    public static void main(String[] args) {
        ExcelSheetColumnNumber171 s = new ExcelSheetColumnNumber171();
        System.out.println(s.titileNumber("AB"));
    }
}
