package LaiOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yuehu on 7/1/20.
 * Sliding window
 */
public class LongestSubstringNonRepeatingCharacter {
    // Assumptions: the input string is not null
    // the distinct set contains all distinct characters
    // int the sliding window of (slow, fast)
    public int longest(String input) {
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while (fast < input.length()) {
            if (distinct.contains(input.charAt(fast))) {
                distinct.remove(input.charAt(slow++));
            } else {
                System.out.println("fast" + fast);
                distinct.add(input.charAt(fast++));
                System.out.println("fast:::" + fast);

                longest = Math.max(longest, fast - slow);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String input = "BDEFGADB";
        LongestSubstringNonRepeatingCharacter l = new LongestSubstringNonRepeatingCharacter();
        System.out.println(l.longest(input));
    }
}
