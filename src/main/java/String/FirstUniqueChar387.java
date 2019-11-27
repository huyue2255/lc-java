package String;

/**
 * Created by yuehu on 4/30/19.
 */
public class FirstUniqueChar387 {

    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)- 'a']++;
        }

        for(int i = 0; i < count.length; i++) {
          if(count[s.charAt(i) - 'a'] == 1) {
              return i;
          }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueChar387 a = new FirstUniqueChar387();
        System.out.println(a.firstUniqChar(s));
    }


}

//for(int i = 0; i < s.length(); i++) {
//        count[s.charAt(i) - 'a']++;
//        }
//
//        for(int i = 0; i < count.length; i++) {
//        if(count[s.charAt(i) - 'a'] == 1) {
//        return i;
//        }
//        }
//        return 0;