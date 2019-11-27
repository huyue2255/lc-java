package String;

/**
 * Created by yuehu on 5/1/19.
 * Q:168. Excel Sheet Column Title
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 */
public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while( n > 0) {
            n--;
            sb.append((char)('A' + n % 26));
            n = n/26;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        int n = 701;
        ExcelSheetColumnTitle168 s = new ExcelSheetColumnTitle168();
        System.out.println(s.convertToTitle(n));
    }
}
