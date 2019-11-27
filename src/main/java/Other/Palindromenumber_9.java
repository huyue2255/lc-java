package Other;

/**
 * Created by yuehu on 7/22/19.
 */
public class Palindromenumber_9 {
    public boolean isPalindrome(int x) {
        if(x < 0 || x != 0 && x % 10 == 0) return false;
        int palind = x;
        int rev = 0;
        while(x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        System.out.println(rev);
        return palind == rev;
    }

    public static void main(String[] args) {
        int x = 121;
        Palindromenumber_9 s = new Palindromenumber_9();
        System.out.println(s.isPalindrome(x));
    }
}
