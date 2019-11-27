package String;

/**
 * Created by yuehu on 4/30/19.
 */
public class RansomNote383 {
    public boolean ransomNote(String ransom, String magazin) {
        int[] count = new int[26];
        for(int i = 0; i < magazin.length(); i++) {
            count[magazin.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransom.length(); i++) {
            if(--count[ransom.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote383 a = new RansomNote383();
        String s = "hello";
        String t = "hellw";
        System.out.println(a.ransomNote(t,s));
    }

}
