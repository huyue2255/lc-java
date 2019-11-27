package String;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by yuehu on 5/1/19.
 * 266. Palindrome Permutation
 * Given a string, determine if a permutation of the string could form a palindrome.

 Example 1:

 Input: "code"
 Output: false
 Example 2:

 Input: "aab"
 Output: true
 两种写法，一种Hashset一种是counting number
 */
public class PalindromePermutation266 {
    //space:O(n)
    public boolean canPermutePalidrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) {
                set.remove(ch);
            }else {
                set.add(ch);
            }
        }
        return set.size() <= 1;
    }

    //space:O(1)
    public boolean canPermutePalindrome1() {
        char[] count = new char[256];
        int res = 0;
        for (char c : toString().toCharArray()) {
            if(count[c] > 0) {
                count[c]--;
            }else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                res++;
            }
        }
        return res <= 1;

    }

    public static void main(String[] args) {
        char[] count = new char[256];
        count['a']++;
        count['b']++;
        char s = 'b';
        int ic = s;

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                System.out.println(i);
            }
        }
        System.out.println(ic);

    }
}
