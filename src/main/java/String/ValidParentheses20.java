package String;
import java.util.Stack;

/**
 * Created by yuehu on 10/9/18.
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.

 case1:(){}[]
 stack: )

 case2:([)]

 ])
 case3:}
 {[()]}

    )]}

 相同点：大家都返回栈顶的值。
 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            if(ch == '(') {
                stack.push(')');
            }else if(ch == '{') {
                stack.push('}');
            }else if(ch == '[') {
                stack.push(']');
            }else {
                if(stack.isEmpty() || stack.peek() != ch) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
        }




    public static void main(String[] args) {
        String s = "{}(]";
//        String.ValidParentheses20 a = new String.ValidParentheses20();
//        a.reverseString(s);
        ValidParentheses20 a = new ValidParentheses20();
        System.out.println(a.isValid(s));
//        System.out.println(s.indexOf("abc",2));
//        System.out.println( a.isValid(s));

    }
}
