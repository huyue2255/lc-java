package Basic;

import java.util.HashMap;

/**
 * Created by yuehu on 10/14/17.
 * no:290
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] str1 = str.split(" ");
        if (pattern.length() != str1.length) {
            return false;
        }

        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            String p = pattern.charAt(i)+"";
            String s = str1[i];

            if (hm1.containsKey(p)) {
                if(!hm1.get(p).equals(s)){
                    return false;
                }
            }else{
                hm1.put(p, s);
            }

            if(hm2.containsKey(s)){
                if(!hm2.get(s).equals(p)){
                    return false;
                }
            }else{
                hm2.put(s,p);
            }
        }
        return true;
    }
    public static void main(String args[]) {
        WordPattern s = new WordPattern();
        String p = "abba";
        String str = "dog dog dog dog";
        System.out.println(s.wordPattern(p, str));
    }
}
