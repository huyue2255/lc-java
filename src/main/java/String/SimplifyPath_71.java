package String;

import java.util.Stack;

/**
 * Created by yuehu on 8/2/19.
 * 71
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * Input: "/a/./b/../../c/"
 * Output: "/c"
 */
public class SimplifyPath_71 {
    //time O(n) space: O(n)
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/+");
        for(String s : paths) {
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals(".") && !s.equals("")){
                stack.push(s);
            }
        }

        String res = "";
        while(!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        if(res.length() == 0) {
            return "/";
        }
        return res;
    }

}
