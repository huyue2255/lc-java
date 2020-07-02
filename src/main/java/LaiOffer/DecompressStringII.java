package LaiOffer;

import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

/**
 * Created by yuehu on 7/1/20.
 * Q: Given a string in compressed form, decompress in to the original string.
 * The adjacent repeated characters in the original string are compressed to have
 * the character followed by the number of repeated occurrences.
 *
 * Example:  a1c0
 *
 */
public class DecompressStringII {
    // Method 1: inplace......

    // Method 2: using StringBuilder to help.
    public String decompressIII(String input) {
        // Assumptions: input is not null
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int c = 0; c < count; c++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        DecompressStringII p = new DecompressStringII();
        String input = "a1c0c2";
        System.out.println(p.decompressIII(input));
    }

}
