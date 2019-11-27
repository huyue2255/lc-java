package LaiOffer_Java;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuehu on 8/21/19.
 * 3,2,1,4,5,6
 * 0,1,2,3,4,5
 */
public class DequeTest {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);

        int size = deque.size();
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                System.out.println(deque.peekFirst());//3
                System.out.println(deque.pollFirst());//3
            }else {
                System.out.println(deque.peekLast());//6
                System.out.println(deque.pollLast());//6
            }
        }

        System.out.println(deque.peekFirst());
    }
}
