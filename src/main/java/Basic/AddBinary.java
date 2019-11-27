package Basic;

/**
 * Created by yuehu on 10/4/17.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result1 = new StringBuilder();
        int tmp1 ;
        int tmp2;
        int c = 0;
        int[] Ans1;
        int[] Ans2;
        int i = a.length() - 1;
        int j = b.length() - 1;


        while (i >= 0 && j >= 0) {
            Ans1 = help(Character.getNumericValue(a.charAt(i)), Character.getNumericValue(b.charAt(j)), c);
            tmp1 = Ans1[0];
            c = Ans1[1];
            result1.append(tmp1);
            i--;
            j--;
        }


        while (i >= 0){
            Ans2 = help(Character.getNumericValue(a.charAt(i)), 0, c);
            tmp2 = Ans2[0];
            c = Ans2[1];
            result1.append(tmp2);
            i--;
        }

        while (j >= 0){
            Ans2 = help(0, Character.getNumericValue(b.charAt(j)), c);
            tmp2 = Ans2[0];
            c = Ans2[1];
            result1.append(tmp2);
            j--;
        }

        if(c != 0){
            result1.append(1);
        }

        return result1.reverse().toString();
    }

    public int[] help(int a, int b, int c) {
        int[] tmp = new int[2];
        int cur;
        if (c + a + b == 0) {
            cur = 0;
            c = 0;
        } else if (c + a + b == 1) {
            cur = 1;
            c = 0;
        } else if (c + a + b == 2) {
            cur = 0;
            c = 1;
        } else {
            cur = 1;
            c = 1;
        }
        tmp[0] = cur;
        tmp[1] = c;
        return tmp;

    }


    public static void main(String args[]) {
        AddBinary s = new AddBinary();
        String a = "101";
        String b = "11";
        System.out.println(s.addBinary(a, b));
    }


}


//        StringBuilder c = new StringBuilder();
//        StringBuilder result = new StringBuilder();
//        int diff = a.length() > b.length() ? a.length()-b.length() : b.length()-a.length();
//        String diffValue = a.length() > b.length() ? b : a;
//
//
//        for(int i = 0; i < diff; i++){
//            c.append(0);
//        }
//
//        c.append(diffValue);


//        int diff = a.length() > b.length() ? b.length() : a.length();
//        int c = 0;
//                int cur;
//        for (int i = 0; i < diff; i++) {
//            int aValue = (int) (a.charAt(a.length() - 1 - i));
//            int bValue = (int) (a.charAt(b.length() - 1 - i));
//            if (c + aValue + bValue == 0) {
//                cur = 0;
//                c = 0;
//            } else if (c + aValue + bValue == 1) {
//                cur = 1;
//                c = 0;
//            } else if (c + aValue + bValue == 2) {
//                cur = 0;
//                c = 1;
//            } else {
//                cur = 1;
//                c = 1;
//            }
// tmp.append(cur).append(c);
//                tmp.append(cur);
//                }
//                return tmp.toString();
//                }
