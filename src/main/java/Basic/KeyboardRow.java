package Basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by yuehu on 10/13/17.
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        ArrayList<String> arraylist = new ArrayList<>();
        HashMap<Character,Integer> hm1 = new HashMap<>();
        char[] row1 = {'q','w','e','r','t','y','u','i','o','p'};
        char[] row2 = {'a','s','d','f','g','h','j','k','l'};
        char[] row3 = {'z','x','c','v','b','n','m'};

        for(int i = 0; i < row1.length; i++){
            hm1.put(row1[i],1);
        }
        for(int i = 0; i < row2.length; i++){
            hm1.put(row2[i],2);
        }
        for(int i = 0; i < row3.length; i++){
            hm1.put(row3[i],3);
        }

        for(String item : words){
            if(check(item,hm1)){
                arraylist.add(item);
            }
        }

        String[] result = new String[arraylist.size()];
        int x = 0;
        for (String n : arraylist) {
            result[x++] = n;
        }

        return result;
    }

    public boolean check(String str, HashMap hm) {
        String str1 = str.toLowerCase();


        for (int i = 0; i < str1.length() - 1; i++) {
            if (hm.get(str1.charAt(i)) != hm.get(str1.charAt(i+1))) {
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]) {
//        HashMap<Character,Integer> hm1 = new HashMap<>();
//        char[] row1 = {'q','w','e','r','t','y','u','i','o','p'};
//        char[] row2 = {'a','s','d','f','g','h','j','k','l'};
//        char[] row3 = {'z','x','c','v','b','n','m'};
//
//        for(int i = 0; i < row1.length; i++){
//            hm1.put(row1[i],1);
//        }
//        for(int i = 0; i < row2.length; i++){
//            hm1.put(row2[i],2);
//        }
//        for(int i = 0; i < row3.length; i++){
//            hm1.put(row3[i],3);
//        }
//
        KeyboardRow s = new KeyboardRow();
        String[] str = {"Hello", "Alaska", "Dad", "Peace"};
//        System.out.println(s.check("Peace",hm1));
        String[] result = s.findWords(str);
        System.out.println(Arrays.toString(result));
    }
}
