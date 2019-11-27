package Other;

/**
 * Created by yuehu on 7/23/19.
 */
public class intToRoman_12 {
    public String intToRoman(int num) {
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","VI","I"};
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            while(num >= values[i]){
                num = num - values[i];
                sb.append(strs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(s.substring(0,0));
    }
}
