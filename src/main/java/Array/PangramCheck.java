package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 5/20/19.
 */
public class PangramCheck {
    public void checkPangram(String Str) {
        Str = Str.replace(" ", "");
        Set<Character> set = new HashSet<>();
        for(char c:Str.toUpperCase().toCharArray()){
            if(Character.isLetter(c))
                set.add(c);
        }
        if(set.size()==26)
            System.out.println("pnagram");
        else
            System.out.println("not pnagram");
    }

    public static void main(String[] args) {
        PangramCheck a = new PangramCheck();
        String str = "abcdefghijklmnopqrs tuvwxkkkyz";
        a.checkPangram(str);
    }
}
