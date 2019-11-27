package LaiOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuehu on 11/11/19.
 * stack1: to buffer all new element (push x goes to stack1)
 * stack2: to pop out the 1th element
 * if stack 2 is empty: remove all ele from 1 -> 2, then pop ele from 2
 * if stack 2 is not empty, then pop ele from 2
 * TIME O(1)
 */
public class QueueByTwoStack {
    private Deque<Integer> in;
    private Deque<Integer> out;

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
