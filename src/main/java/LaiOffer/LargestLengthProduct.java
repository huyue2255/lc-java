package LaiOffer;

import sun.nio.cs.ext.MacThai;

import java.util.HashMap;

/**
 * Created by yuehu on 10/14/20.
 *
 *
 */
public class LargestLengthProduct {
    // Method 1
    public int bitNumber(char ch) {
        return (int)ch - (int)'a';
    }

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        int bitmask = 0;
        for (int i = 0; i < n; i++) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                // add bit number bit_number in bitmask
                bitmask |= 1 << bitNumber(ch);
            }
            masks[i] = bitmask;
            lens[i] = words[i].length();
        }
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxVal = Math.max(maxVal, lens[i] * lens[j]);
                }
            }
        }
        return maxVal;
    }

    // Method 2
    // given a dictionary containing many words




}
