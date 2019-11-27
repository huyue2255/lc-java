package Basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 10/22/17.
 */
public class LongestSubstrNoDup {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character,Integer> hm = new HashMap<>();

        int i = 0;
        int max = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            if (!hm.containsKey(c)) {
                hm.put(c,i);
                max = Math.max(max, hm.size());
            } else {
                fun(i,hm);
                hm.put(c,i);
            }
            i++;

        }
        return max;
    }


    public static void main(String args[]){
        LongestSubstrNoDup s = new LongestSubstrNoDup();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }

    public  void fun(int n, HashMap<Character, Integer> map) {

        Set<Character> ss = new HashSet<>();
        for (Character c : map.keySet()) {
            ss.add(c);
        }

        //Map<Character, Integer> m = new HashMap<>();
        for (Character c : ss) {
            if (map.get(c) < n) {
                map.remove(c);
            }
        }

    }

}

//        if (s == null || s.length() == 0) {
//            return 0;
//        }
//
//        HashSet<Character> set = new HashSet<>();
//
//        //char[] ch = s.toCharArray();
//        int i = 0;
//        int max = 0;
//        int start = 0;
//        while (i < s.length()) {
//            char c = s.charAt(i);
//
//            if (!set.contains(c)) {
//                set.add(c);
//                max = Math.max(max, i + 1 - start);
//            } else {
//                for (int j = start; j < i; j++) {
//                    set.remove(s.charAt(j));
//
//                    if (s.charAt(j) == c) {
//                        start = j + 1;
//                        break;
//                    }
//                }
//                set.add(c);
//            }
//            i++;
//        }
//        return max;
//    }

