package String;

/**
 * Created by yuehu on 5/26/19.
 */
public class DetectCapital520 {
    public boolean detectCapitalUse(String word) {
        int numUpper = 0;
        for (int i = 0; i < word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))){
                numUpper++;
            }
        }
        if(numUpper == 1) {
            return Character.isUpperCase(word.charAt(0));
        }

        return numUpper == 0 || numUpper == word.length();
    }

    public static void main(String[] args) {
        String word = "USAuuuuW";
        DetectCapital520 s = new DetectCapital520();
        System.out.println(s.detectCapitalUse(word));
    }
}
