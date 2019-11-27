package String;

import java.util.HashMap;

/**
 * Created by yuehu on 4/24/19.
 * Q205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic.

 * Two strings are isomorphic if the characters in s can be replaced to get t.

 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to the
 * same character but a character may map to itself.
 * Hashmap/counting sort
 */
public class IsomorphicStrings205 {
    //time: O(n*n), space:O(1)
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character,Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)) {
                if(map.get(a).equals(b)) {
                    continue;
                }else {
                    return false;
                }
            }else {
                if(!map.containsValue(b)){
                    map.put(a,b);
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egge";
        String s1 = "abb";
        IsomorphicStrings205 a = new IsomorphicStrings205();
        System.out.println(a.isIsomorphic(s,s1));

    }

}
