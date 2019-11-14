package LaiOffer;

import java.util.LinkedList;

/**
 * Created by yuehu on 11/11/19.
 */
public class QueueByTwoStack {
    private LinkedList<Integer> in;
    private LinkedList<Integer> out;

    public QueueByTwoStack() {
        in = new LinkedList<Integer>();
        out = new LinkedList<Integer>();
    }

    public Integer poll() {
        move();
        return out.isEmpty() ? null : out.pollFirst();
    }

    public void offer(int value) {
        in.offerFirst(value);
    }

    public Integer peek() {
        move();
        return out.isEmpty() ? null : out.peekFirst();
    }

    // when out stack is empty, move the elements from
    // in stack to out stack

    private void move() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.offerFirst(in.pollFirst());
            }
        }
    }

    public int size() {
        return in.size() + out.size();
    }

    public boolean isEmpty() {
        return in.size() == 0 && out.size() == 0;
    }

    public static void main(String[] args) {
        QueueByTwoStack q = new QueueByTwoStack();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println(q.poll());
    }

}
