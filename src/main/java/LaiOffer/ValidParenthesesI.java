package LaiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuehu on 6/1/20.
 */
public class ValidParenthesesI {
    public List<String> validParentheses(int k) {
        List<String> result = new ArrayList<String>();
        // the final string contains 2k characters.
        char[] cur = new char[k * 2];
        helper(cur, k, k, 0, result);
        return result;
    }

    // left: how many '(' we still have
    // right: how many ')' we still have
    // index: the current position in cur we want to fill in with either '(' or ')'

    private void helper(char[] cur, int left, int right, int index, List<String> result) {
        // terminate condition
        // when we do not have any parentheses left
        if (left == 0 && right ==0) {
            result.add(new String(cur));
            return;
        }

        // when we can add a '(' ? whenever there is some '(' we can still use.
        if (left > 0) {
            cur[index] = '(';
            helper(cur, left - 1, right, index+1, result);
        }
        // when we can add a ')' ? when there is more '(' than ')' used.
        // because each ')' should be associated with a previous '('
        if (right > left) {
            cur[index] = ')';
            helper(cur, left, right - 1, index+1, result);
        }
    }

    public static void main(String[] args) {
        ValidParenthesesI s = new ValidParenthesesI();
        System.out.println(s.validParentheses(3));

    }

}
