package String;

/**
 * Created by yuehu on 5/1/19.
 * Q:13 Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

 Symbol       Value
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 */
public class RomanToInteger13 {
    public int help(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        char[] target = s.toCharArray();
        int sum = 0;
        if(target.length == 1) return help(target[0]);
        for(int i = 0; i < target.length - 1; i++){
            if(target[i] >= target[i+1]){
                sum = sum + help(target[i]);
            }else if(target[i] < target[i+1]){
                sum = sum - target[i];
            }
        }
        return  sum + help(target[target.length - 1]);
    }

    public static void main(String[] args) {
        RomanToInteger13 s = new RomanToInteger13();
        System.out.println(s.romanToInt("VV"));

    }
}

//
//    char[] target = s.toCharArray();
//    int result = 0;
//        if(target.length == 1) {
//                return help(target[0]);
//                }
//                for(int i = 0; i < target.length - 1; i++) {
//        if(help(target[i]) >= help(target[i+1])){
//        result = result + help(target[i]);
//        }else if(help(target[i]) < help(target[i+1])) {
//        result = result - help(target[i]);
//        }
//        }
//        return result + help(target[target.length - 1]);