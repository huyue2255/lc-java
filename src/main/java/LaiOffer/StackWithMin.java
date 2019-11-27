package LaiOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yuehu on 11/11/19.
 */
public class StackWithMin {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public StackWithMin() {
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    public Integer min() {
        if (minStack.isEmpty()) {
            return null;
        }
        return minStack.peekFirst();
    }

    public void push(int value) {
        stack.offerFirst(value);

        if (minStack.isEmpty() || value <= minStack.peekFirst()) {
            minStack.offerFirst(value);
        } else {
            minStack.offerFirst(minStack.peekFirst());
        }

    }

    public Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }

        Integer result = stack.pollFirst();
        if (minStack.peekFirst().equals(result)) {
            minStack.pollFirst();
        }
        return result;
    }

    public Integer top() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peekFirst();
    }

    public static void main(String[] args) {
        StackWithMin  stack = new StackWithMin();
        stack.push(1);
        stack.push(0);
        stack.push(6);
        stack.push(3);
//        stack.push(0);

        System.out.println(stack.min());


    }

}
