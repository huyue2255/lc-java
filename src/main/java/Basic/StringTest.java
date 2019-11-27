package Basic;

/**
 * Created by yuehu on 7/16/19.
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
//        str1 = "xyz";
        System.out.println(str1);//true

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(str1 == str2);//true

        System.out.println(s1.equals(s2));//true

        Integer i = 1234;
        Integer j = 1234;
        System.out.println(i == j);
        System.out.println(i.equals(j));

    }
}
