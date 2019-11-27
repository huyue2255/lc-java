package String;

import java.util.HashSet;

/**
 * Created by yuehu on 7/21/19.
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.

 */
//hashset
public class LongestSubstringWithoutRepeatingCharacter_3 {
    public int lengthOfLongestSubstring(String s) {
        //abba
        // if (s == null || s.length() == 0) return 0;
        //     HashMap<Character, Integer> map = new HashMap<>();
        //     int res = 0;
        //     for (int i = 0, j = 0; i < s.length(); i++) {
        //         if (map.containsKey(s.charAt(i))) {
        //             j = Math.max(j, map.get(s.charAt(i)) + 1);
        //         }
        //         map.put(s.charAt(i), i);
        //         res = Math.max(res, i - j + 1);
        //     }
        //     return res;
        // }

        //aab//abba
        if(s == null || s.length() ==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(j++));
                i--;
            }else {
                set.add(s.charAt(i));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }

;    public static void main(String[] args) {
        String str = "abcbd";
        LongestSubstringWithoutRepeatingCharacter_3 s = new LongestSubstringWithoutRepeatingCharacter_3();
        System.out.println(s.lengthOfLongestSubstring(str));

    }

}
