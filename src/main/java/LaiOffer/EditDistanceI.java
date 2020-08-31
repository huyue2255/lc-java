package LaiOffer;

/**
 * Created by yuehu on 8/19/20.
 * Q: Given two strings s and t, determine if they are both one edit distance apart.
 */
public class EditDistanceI {
    public boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        // Ensure that s.length <= t.length
        if (ns > nt) {
            return isOneEditDistance(t,s);
        }
        // The strings are not one eidt away distance
        // if the length diff is more than 1.
        if (ns - nt > 1) {
            return false;
        }

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        return ns + 1 == nt;
    }

}
