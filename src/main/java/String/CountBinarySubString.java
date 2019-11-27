package String;

/**
 * Created by yuehu on 11/19/18.
 * 11100: 1100,10
 * 00110011: 0011,01,1100,10,0011,01
 * cur记录当前扫描的字符的出现次数
 * pre记录的是前一种字符出现的次数
 */
public class CountBinarySubString {

    public int countBinarySubstring(String s) {
        int res = 0, pre = 0, cur = 1;
        int n = s.length();
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cur++;
            }else {
                res = res + Math.min(pre,cur);
                pre = cur;
                cur = 1;
            }
        }

        return res+(Math.min(pre,cur));
    }

    public static void main(String[] args) {
        CountBinarySubString d = new CountBinarySubString();
        String b = "0011101";
        d.countBinarySubstring(b);
        System.out.println(d.countBinarySubstring(b));

    }
}
