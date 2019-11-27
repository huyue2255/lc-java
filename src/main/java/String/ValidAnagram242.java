package String;

import java.util.Arrays;

/**
 * Created by yuehu on 4/24/19.
 * Q242. Valid Anagram
 * Given two strings s and t , write a function to determine if t is an anagram of s.

 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Counting sort
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int num:count) {
            if(num != 0) {
                return false;
            }
        }
        return true;
    }

//    public boolean isAnagram2() {
//
//    }



    public static void main(String[] args) {
//        System.out.println('d' - 'a');
        ValidAnagram242 a = new ValidAnagram242();
        String w1 = "hello";
        String w2 = "ehldo";
        System.out.println(a.isAnagram(w1,w2));
        int[] sample = new int[10];
        //convert array to string and print
        System.out.println(Arrays.toString(sample));
    }

}
