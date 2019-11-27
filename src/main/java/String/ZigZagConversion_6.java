package String;

/**
 * Created by yuehu on 7/22/19.
 * Example 1:

 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:

 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:

 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Time: O(n), Space: O(n)
 */
public class ZigZagConversion_6 {
    public String convert(String s, int numRows){
        if(numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }

        for(int i = 0; i < s.length(); i++){
            int index = i % (numRows * 2 - 2);
            index = index < numRows ? index : numRows*2 -2 -index;
            sb[index].append(s.charAt(i));
        }

        for(int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZagConversion_6 a = new ZigZagConversion_6();
        String res = a.convert(s,3);
        System.out.println(res);
    }
}
