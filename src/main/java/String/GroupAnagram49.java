package String;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yuehu on 4/30/19.
 * counting sort & hashmap； counting为key,字符串为value
 */
public class GroupAnagram49 {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String,List<String>> map = new HashMap<>();
       for(String str : strs) {
           int[] count = new int[26];
           for(Character ch : str.toCharArray()){
               count[ch - 'a']++;
           }

           String s = "";

           for(int i = 0; i < count.length; i++) {
               if(count[i] != 0) {
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
               }
           }

           if(map.containsKey(s)) {
               List<String> list = map.get(s);
               list.add(str);
           }else {
               List<String> list = new ArrayList<>();
               list.add(str);
               map.put(s,list);
           }
       }

       return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat","aet"};
        GroupAnagram49 s = new GroupAnagram49();
//        s.groupAnagrams(str);
        System.out.println(s.groupAnagrams(str));

    }
}
