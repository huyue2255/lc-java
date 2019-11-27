package Basic;

import java.util.HashMap;

import java.util.Map;


/**
 * Created by yuehu on 10/8/17.
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm1 = new HashMap<>();
        String ransomNote1 = ransomNote.toLowerCase();
        String magazine1 = magazine.toLowerCase();


        if(ransomNote == null || ransomNote.length() == 0){
            return  true;
        }

        if( magazine == null || magazine.length() == 0){
            return false;
        }

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        for (int i = 0; i < magazine1.length(); i++) {
            if (hm1.containsKey(magazine1.charAt(i))) {
                hm1.put(magazine1.charAt(i), hm1.get(magazine1.charAt(i)) + 1);
            } else {
                hm1.put(magazine1.charAt(i), 1);
            }
        }

        for(int i = 0; i < ransomNote1.length(); i++){
            if(!hm1.containsKey(ransomNote1.charAt(i))){
                return false;
            }

            if(hm1.get(ransomNote1.charAt(i)) - 1 >= 0){
                hm1.put(ransomNote1.charAt(i),hm1.get(ransomNote1.charAt(i)) - 1);
            }else{
                return false;
            }

        }
        return  true;


    }
//        Map<Character, Integer> hm1 = new HashMap<>();
//        Map<Character, Integer> hm2 = new HashMap<>();
//        String ransomNote1 = ransomNote.toLowerCase();
//        String magazine1 = magazine.toLowerCase();
//
//
//        if(ransomNote == null || ransomNote.length() == 0){
//            return  true;
//        }
//
//        if( magazine == null || magazine.length() == 0){
//            return false;
//        }
//
//        if(ransomNote.length() > magazine.length()){
//            return false;
//        }
//
//        for (int i = 0; i < magazine1.length(); i++) {
//            if (hm1.containsKey(magazine1.charAt(i))) {
//                hm1.put(magazine1.charAt(i), hm1.get(magazine1.charAt(i)) + 1);
//            } else {
//                hm1.put(magazine1.charAt(i), 1);
//            }
//        }
//
//
//        for (int j = 0; j < ransomNote1.length(); j++) {
//            if (hm2.containsKey(ransomNote1.charAt(j))) {
//                hm2.put(ransomNote1.charAt(j), hm2.get(ransomNote1.charAt(j)) + 1);
//            } else {
//                hm2.put(ransomNote1.charAt(j), 1);
//            }
//        }
//
//
//        for (Character e : hm2.keySet()) {
//            if (!hm1.keySet().contains(e)) {
//                return false;
//            }
//
//            if (hm1.get(e) < hm2.get(e)) {
//                return false;
//            }
//        }
//        return true;
//
//    }

    public static void main(String args[]){
        RansomNote s = new RansomNote();
        String ransomNote = "abcd";
        String magazine = "abcde";
        System.out.println(s.canConstruct(ransomNote,magazine));

    }

}