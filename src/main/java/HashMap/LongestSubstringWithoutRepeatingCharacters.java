package HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import java.util.Iterator;

/**
 * Created by yuehu on 2/3/19.
 *
 * 3 Longest Substring Without Repeating Characters
 * given "abcabcdebb" result "adcde" => 5
 * given "abccab"
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            res = Math.max(res, i-j+1);
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
               set.remove(s.charAt(j++));
            } else {
               set.add(s.charAt(i));
               res = Math.max(res,set.size());
            }
        }
        return res;
    }


    public static void main(String args[]) {
        HashMap<Character, Integer> map = new HashMap<>();

        String s = "abccab";
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        int res = a.lengthOfLongestSubstring1(s);
        System.out.println(res);

//=======same key ,then value will be overwrite==========
        HashMap<Character, Integer> map1 = new HashMap<>();
        map1.put('a',0);
        map1.put('a',1);
        map1.put('a',2);
        map1.put('b',3);
        map1.put('c',3);
        Iterator iter = map1.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
        }

    }
}
