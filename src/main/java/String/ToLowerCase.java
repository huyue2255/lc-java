package String;

/**
 * Created by yuehu on 10/10/18.
 * 709. To Lower Case
 */
public class ToLowerCase {

    public String toLowerCase(String str){
        char[] cr = str.toCharArray();
        for(int i = 0; i < cr.length; i++){
            cr[i] = Character.toLowerCase(cr[i]);
        }
        return new String(cr);
    }


    public static void main(String[] args) {
        ToLowerCase s = new ToLowerCase();
        String a = "HEllO world!";

        System.out.println(s.toLowerCase(a));
    }
}
