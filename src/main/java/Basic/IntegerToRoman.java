package Basic;

/**
 * Created by yuehu on 10/20/17.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String dict[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Integer val[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < val.length; i++) {
            if (num >= val[i]) {
                int count = num / val[i];
                num %= val[i];
                for (int j = 0; j < count; j++) {
                    ret.append(dict[i]);
                }
            }
        }
        return ret.toString();
    }

    public static void main(String args[]){
        IntegerToRoman s = new IntegerToRoman();
        System.out.println(s.intToRoman(600));
    }
}
