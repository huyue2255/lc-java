package String;

import java.util.HashMap;

/**
 * Created by yuehu on 4/24/19.
 * Q290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that
 * there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 */
public class WordPattern290 {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(map.containsKey(c)) {
                if(map.get(c).equals(arr[i])) {
                    continue;
                } else {
                    return false;
                }
            }else {
                if(!map.containsValue(arr[i])) {
                    map.put(c,arr[i]);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaabb";
        String word = "word word word ha ha";
        WordPattern290 s = new WordPattern290();
        System.out.println(s.wordPattern(pattern,word));

    }
}
