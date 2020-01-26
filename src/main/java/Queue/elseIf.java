package Queue;

/**
 * Created by yuehu on 1/25/20.
 */
public class elseIf {
    public static void main(String[] args) {
        elseIf elseif = new elseIf();
        elseif.test(2);
    }
//
//    public static void swap(int[] array, int a, int b) {
//        int temp = array[a];
//        array[a] = array[b];
//        array[b] = array[temp];
//    }

    public void test(int a) {
        if (1 < a) {
            System.out.println(1111);
        } else if (11 > a) {
            System.out.println(2222);
        } else {
            System.out.println(3333);
        }

    }
}
