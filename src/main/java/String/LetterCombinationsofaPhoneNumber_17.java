package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 7/24/19.
 */
public class LetterCombinationsofaPhoneNumber_17 {
    private String[] mapping = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        helper(res, digits,"",0);
        return res;
    }

    public void helper(List<String> res, String digits, String s, int index) {
        if(index == digits.length()){
            res.add(s);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            helper(res, digits, s + letters.charAt(i),index + 1);
        }
    }
}
