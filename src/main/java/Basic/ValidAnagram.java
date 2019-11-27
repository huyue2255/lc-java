package Basic;

import java.util.Arrays;

/**
 * Created by yuehu on 10/13/17.
 * no:242
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for(int i =0;i<ss.length;i++){
            if(ss[i]!=tt[i]){
                return false;
            }
        }
        return true;

    }
//        if (s == null && t == null) {
//            return true;
//
//        }
//
//        if (s == null || t == null) {
//            return false;
//        }
//
//
//        if (s.length() == 0 && t.length() == 0) {
//            return true;
//        }
//
//        if (s.length() != t.length()) {
//            return false;
//        }
//
//        HashMap<Character, Integer> hm1 = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            if (hm1.containsKey(s.charAt(i))) {
//                hm1.put(s.charAt(i), hm1.get(s.charAt(i)) + 1);
//            } else {
//                hm1.put(s.charAt(i), 1);
//            }
//        }
//
//        for (int j = 0; j < t.length(); j++) {
//            if (!hm1.containsKey(t.charAt(j))) {
//                return false;
//            } else {
//                hm1.put(t.charAt(j), hm1.get(t.charAt(j)) - 1);
//                if (hm1.get(t.charAt(j)) < 0) {
//                    return false;
//                }
//            }
//        }
//
//        return true;
//
//    }

    public static void main(String args[]) {

        ValidAnagram ss = new ValidAnagram();
        String s1 = "aaca";
        String tt = "aaac";
        System.out.println(ss.isAnagram(s1, tt));

    }
}