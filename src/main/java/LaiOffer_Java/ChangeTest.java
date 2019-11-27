package LaiOffer_Java;

/**
 * Created by yuehu on 8/19/19.
 */
public class ChangeTest {
    static class Simple {
        public int value;

        public Simple (int v) {
            value = v;
        }
    }

    public static void main(String[] args) {
        int x = 5;
        changeIntValue(x);
        System.out.println(x);

//        Simple originalSimple = new Simple(5);
//        changeSimpleValue1(originalSimple);
//        System.out.println(originalSimple.value);
//
//        Simple originalSimple = new Simple(5);
//        changeSimpleValue2(originalSimple);
//
//        System.out.println(originalSimple.value);
//
//        Simple originalSimple = new Simple(5);
//        originalSimple = changeSimpleValue3(originalSimple);
//        System.out.println(originalSimple.value);
    }

    private static void changeIntValue(int x) {
        x = 10;
    }

    private static void changeSimpleValue1(Simple simple) {
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static void changeSimpleValue2(Simple simple) {
        simple.value = 10;
    }

    private static Simple changeSimpleValue3(Simple simple) {
        Simple newSimple = new Simple(10);
        return newSimple;
    }


}
