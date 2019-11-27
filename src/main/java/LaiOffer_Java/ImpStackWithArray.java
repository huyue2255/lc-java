package LaiOffer_Java;

/**
 * Created by yuehu on 8/21/19.
 */
public class ImpStackWithArray {
    int[] array;
    int head;

    public ImpStackWithArray(int cap) {
        array = new int[cap];
        head = -1;
    }

    public boolean push(int ele) {
        if (head == array.length - 1) {
            return false;
        }

        array[++head] = ele;
        return true;
    }

    public Integer pop() {
        return head == -1 ? null : array[head--];
    }
}
