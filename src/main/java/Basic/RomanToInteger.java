//import com.sun.org.apache.bcel.internal.generic.RETURN;
//
///**
// * Created by yuehu on 10/3/17.
// */
//public class RomanToInteger {
//    public int help(char c) {
//        switch (c) {
//            case 'I':
//                return 1;
//            case 'V':
//                return 5;
//            case 'X':
//                return 10;
//            case 'L':
//                return 50;
//            case 'C':
//                return 100;
//            case 'D':
//                return 500;
//            case 'M':
//                return 1000;
//
//            default:
//                return 0;
//        }
//
//    }
//
//    public int romanToInt(String s) {
//
//
//        char[] target = s.toCharArray();
//        int result = 0;
//        if(target.length == 1){
//            return help(target[0]);
//        }
//
//
//        for (int i = 0; i < target.length - 1; i++) {
//            if (help(target[i]) >= help(target[i + 1])) {
//                result += help(target[i]);
//            } else if (help(target[i]) < help(target[i + 1])) {
//                result = result - help(target[i]);
//            }
//        }
//        return result + help(target[target.length - 1]);
//
//    }
//
//    public static void main(String args[]) {
//
//        String s = "MMMCMXCIX";
//        //System.out.println(s.charAt(0));
//        RomanToInteger a = new RomanToInteger();
//        //System.out.println(a.help(s.charAt(0)));
//        System.out.println(a.romanToInt(s));
//
//    }
//
//}