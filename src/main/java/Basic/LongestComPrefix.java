package Basic;

import java.util.Arrays;

/**
 * Created by yuehu on 10/3/17.
 */
public class LongestComPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }



        if(strs[0] == null || strs[0].length() == 0){
            return "";
        }

        if(strs[0].charAt(0) != strs[strs.length - 1].charAt(0)){
            return "";
        }


        StringBuilder result = new StringBuilder();
        int n = strs[0].length() <= strs[strs.length - 1].length() ? strs[0].length() : strs[strs.length - 1].length();

        for(int i = 0; i < n; i++){
            if(strs[0].charAt(i) == strs[strs.length - 1].charAt(i)){
                result.append(strs[0].charAt(i));
            }else{
                break;
            }

        }
        return result.toString();

    }

    public static void main(String args[]){
//        String[] strs = {"1,2,3","1,2,3,4","1,2,3","1,2,3,5"};
        String[] strs = {"abaa","abca","abc"};
        Arrays.sort(strs);
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        System.out.println(strs[2]);
//        System.out.println(strs[3]);
        LongestComPrefix a = new LongestComPrefix();
        a.longestCommonPrefix(strs);
        System.out.println("output");
        System.out.println(a.longestCommonPrefix(strs));
    }
}
