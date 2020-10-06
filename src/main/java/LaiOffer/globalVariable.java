package LaiOffer;


/**
 * Created by yuehu on 9/19/20.
 */
public class globalVariable {

    public int callUpdate() {
        int a  = Integer.MIN_VALUE;
        updateValue(a);
        System.out.println("callUpdate" + a);
        return a;
    }

    public void updateValue(int a) {
        System.out.println("before updateValue" + a);
        a = 100;
        System.out.println("updateValue" + a);
        return;
    }

    public static void main(String[] args) {
        globalVariable g = new globalVariable();
        System.out.println(g.callUpdate());
    }
}
