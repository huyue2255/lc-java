package LaiOffer;

import Basic.test;

import java.util.HashSet;

/**
 * Created by yuehu on 6/28/20.
 */
public class MissingNumberI {
    // method 1: use HashSet
    // Assumption: array is not null.
    public int missing(int[] array) {
        int n = array.length + 1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int number: array) {
            set.add(number);
        }
        for (int i = 1; i < n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n;
    }

    // method 2: use sum
    public int missingII(int[] array) {
        int n = array.length + 1;
        long targetSum = (n + 0L) * (n + 1) / 2;
        long actualSum = 0L;
        for (int num: array) {
            actualSum += num;
        }
        return (int) (targetSum - actualSum);
    }

    // method 3: bit operation. - O(n)
    public int missingIII(int[] array) {
        int n = array.length + 1;
        int xor = 0;
        // xor 1 to n
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        // after this operation, all the number from 1 to n
        // are pair xor'ed expect for the missing number.
        // since x ^ x = 0, the remaining number is the result.


        for (int num: array) {
            xor ^= num;
        }
        return xor;
    }

    public static void main(String[] args) {
        MissingNumberI m = new MissingNumberI();
        int[] test = {1,2,4};
        System.out.println(m.missingIII(test));
    }

}
