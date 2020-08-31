package LaiOffer;

/**
 * Created by yuehu on 7/11/20.
 * Q: Determine whether a word contains all letters that unique (no duplicate letters in whe word)
 * Assumption:
 * We are using ASCII encoding and the number of valid letters is 256, encode from 0-255
 * The input word is not null
 */
public class AllUniqueCharsII {
    // 26 a-z
    public  boolean isUnique(String word) {
        if (word == null) {
            return true;
        }

        int dic = 0;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            if (((dic >>> pos) & 1) == 1) {
                return false;
            } else {
                dic = (dic | (1 << pos));
            }
        }
        return true;
    }

    // all 256 ASCII code
    public boolean isUniqueII(String word) {
        if (word == null) {
            return false;
        }

        int[] dic = new int[8];
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i);
            int row = pos / 32;
            int column = pos % 32;
            if (((dic[row] >>> column & 1)) == 1) {
                return false;
            }
            dic[row] = dic[row] | 1 << column;
        }
        return true;
    }

    public static void main(String[] args) {
        AllUniqueCharsII a = new AllUniqueCharsII();
        System.out.println(a.isUniqueII("abcASC!"));

    }

}
