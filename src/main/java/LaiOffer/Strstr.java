package LaiOffer;

/**
 * Created by yuehu on 6/30/20.
 */
public class Strstr {
    public int srstrI(String large, String small) {
        if (large.length() < small.length()) {
            return -1;
        }
        // return 0 if small is empty
        if (small.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= large.length() - small.length(); i++) {
            int j = 0;
            for (j = 0; j < small.length(); j++) {
                if (small.charAt(j) != large.charAt(i+j)) {
                    break;
                }
            }
            if (j == small.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Strstr str = new Strstr();
        String str1 = "HELLO";
        String str2 = "LLO";
        System.out.println(str.srstrI(str1, str2));
    }


}
