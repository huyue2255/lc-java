package String;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.HashSet;

/**
 * Created by yuehu on 11/19/18.
 * 804
 */
public class UniquMorseCode {
    private  String morses[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-."
            ,"---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorse(String[] words) {
        HashSet<String> set = new HashSet<>();
        for(String s : words){
            int n = s.length();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < n; i++) {
                sb.append(morses[s.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }


    public static  void main(String[] args) {
        String[] words = {"g","z","g","g"};
        UniquMorseCode s = new UniquMorseCode();
        s.uniqueMorse(words);
        System.out.println(s.uniqueMorse(words));

    }



}
