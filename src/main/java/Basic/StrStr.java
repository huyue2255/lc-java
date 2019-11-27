package Basic;

/**
 * Created by yuehu on 10/7/17.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        int j = 0;

        if (needle == null) {
            return -1;
        }

        if(haystack == null) {
            return -1;
        }

        if(needle.length() ==0 ) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        while (j <= (haystack.length() - needle.length())){
//        while (j < haystack.length()){

            int start = j;

            for(int i = 0; i < needle.length(); i++) {
                if (needle.charAt(i) == haystack.charAt(start)) {
                    if( i == needle.length() - 1){
                        return j;
                    }
                    start++;

                } else if (needle.charAt(i) != haystack.charAt(start)) {
                    j++;
                    break;
                }
            }
        }
        return -1;
    }


    public static void main(String args[]) {
        String haystack = "abc";
        String needle = "bc";
        StrStr s = new StrStr();
        System.out.println(s.strStr(haystack, needle));
    }
}
