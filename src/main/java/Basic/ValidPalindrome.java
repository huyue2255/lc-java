package Basic;

/**
 * Created by yuehu on 9/25/18.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int start=0,end=s.length()-1;
        s=s.toLowerCase();
        while(start<end){
            while(start<end && !(s.charAt(start)>='a' && s.charAt(start)<='z')  && !(s.charAt(start)>='0' && s.charAt(start)<='9')) {
                start++;
            }
            while(start<end && !(s.charAt(end)>='a' && s.charAt(end)<='z')  && !(s.charAt(end)>='0' && s.charAt(end)<='9')) {
                end--;
            }
            if(start>=end) {
                break;
            }

            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String args[]){
        ValidPalindrome a = new ValidPalindrome();
        String s = "abccba";
        String s1 = "abcdeadcba";
        System.out.println(a.isPalindrome(s));
        System.out.println(a.isPalindrome(s1));
    }
}


