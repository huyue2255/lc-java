package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuehu on 5/25/19.
 * 500. Keyboard Row
 * Given a List of words, return the words that can be typed using letters
 * of alphabet on only one row's of American keyboard like the image below.
 *
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 */
public class FindWords500 {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop","asdfghjkl","zxcvbnm"};
        HashMap<Character,Integer> keyboard = new HashMap<>();
        for(int i = 0; i < rows.length; i++) {
            for(char c : rows[i].toCharArray()) {
                keyboard.put(c,i);
            }
        }

        List<String> res = new ArrayList<>();
        for(String word : words) {
            if(check(word,keyboard)) {
                res.add(word);
            }
        }
//遍历arraylist, 把arraylist里面的东西放到array里面去
        String[] result = new String[res.size()];
//        int x = 0;
//        for (String n : res) {
//            result[x++] = n;
//        }

        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public boolean check(String str, HashMap hm) {
        String str1 = str.toLowerCase();
        for(int i = 0; i < str1.length() - 1; i++) {
            if(hm.get(str1.charAt(i)) != hm.get(str1.charAt(i+1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindWords500 s = new FindWords500();
        String[] word = {"Hello", "Alaska", "Dad", "Peace","happy","a","s","n"};
        System.out.println(Arrays.toString(s.findWords(word)));
    }
}
