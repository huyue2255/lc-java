package Basic;

import java.util.Stack;

/**
 * Created by yuehu on 10/3/17.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i <  s.length(); i++) {
            if (isLeft(s.charAt(i))){
                st.push(s.charAt(i));
            }else{
                if (st.empty() || !isClose(st.peek(),s.charAt(i))){
                    return false;
                }else{
                    st.pop();
                }
            }
        }
        return st.empty();
    }

    boolean isLeft(char c){
        if (c == '(' || c == '[' || c == '{'){
            return true;
        }else{
            return false;
        }
    }

    boolean isClose(char a, char b){
        if(a == '(' && b == ')'){
            return true;
        }else if(a == '[' && b == ']'){
            return true;
        }else if(a == '{' && b == '}'){
            return  true;
        }
        return false;
    }

    public static void main(String args[]){
        ValidParentheses a = new ValidParentheses();
        String s = "{()}";
        String s1 = "()[]{}";
        System.out.println(a.isValid(s));
        System.out.println(a.isValid(s1));
    }
}
