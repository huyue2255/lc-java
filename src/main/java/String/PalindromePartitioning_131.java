package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 8/10/19.
 * Example:

 Input: "aab"
 Output:
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class PalindromePartitioning_131 {
    public List<List<String>> partiton(String s){
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res,new ArrayList<>(),s);
        return res;
    }

    public void helper(List<List<String>> res, List<String> list, String s) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(isPalidrome(s.substring(0,i+1))) {
                list.add(s.substring(0,i+1));
                helper(res,list,s.substring(i+1));
                list.remove(list.size() - 1);
            }
        }

    }


    public boolean isPalidrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }

}
