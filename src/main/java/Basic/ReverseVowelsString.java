package Basic;

/**
 * Created by yuehu on 10/8/17.
 * 345
 */
public class ReverseVowelsString {
    public String reverseVowels(String s) {
        StringBuilder s1 = new StringBuilder(s);
        int i = 0;
        int j = s1.length() - 1;

        while (i < j) {

            if (isVowel(s1.charAt(i)) && isVowel(s1.charAt(j))) {
                char a = s1.charAt(i);
                char b = s1.charAt(j);
                s1.setCharAt(i, b);
                s1.setCharAt(j, a);
                i++;
                j--;
            } else {
                if (!isVowel(s1.charAt(i))) {
                    i++;
                }
                if(!isVowel(s1.charAt(j))){
                    j--;
                }
            }
        }
        return s1.toString();
    }

    public boolean isVowel(char s) {
        char a = Character.toLowerCase(s);
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') {
            return true;
        }
        return false;
    }


    public static void main(String args[]) {
        ReverseVowelsString s = new ReverseVowelsString();
        String target = "Aa";
//        StringBuilder s1 = new StringBuilder("leetcode");
//        s1.setCharAt(0, 'a');
//        System.out.println(s1);
        System.out.println(s.reverseVowels(target));
    }
}
