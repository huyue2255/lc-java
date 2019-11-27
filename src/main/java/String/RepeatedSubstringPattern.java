package String;

/**
 * Created by yuehu on 10/10/18.
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int mid = len / 2;
        for(int i = mid; i >= 1; i--) {
            if(len % i == 0){
                int cnt = 0;
                int j = 0;
                String sub = s.substring(0,i);
                while(j <= len - i) {
                    if(s.indexOf(sub,j) == j){
                        cnt++;
                        j += i;
                    }else {
                        break;
                    }
                }
                System.out.println(cnt);
                return len/i == cnt;

            }
        }

        return false;

    }

    public static void main(String[] args) {
        RepeatedSubstringPattern a = new RepeatedSubstringPattern();

        String c = "ababababc";
        System.out.println(c.charAt(0));
        System.out.println(c.charAt(0));
        System.out.println(c.substring(0,4));
        System.out.println(c.indexOf("ab",0));
        System.out.println(a.repeatedSubstringPattern(c));
        //#2 test
//        System.out.println('a'-'d');
//        StringBuffer sb = new StringBuffer();
//        sb.append("hello");
//        sb.append("World");
//        System.out.println(sb);
//        HashSet<String> set = new HashSet<>();
//        set.add(sb.toString());
//        System.out.println(set.size());

    }

}
