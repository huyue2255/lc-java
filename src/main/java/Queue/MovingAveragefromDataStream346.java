package Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yuehu on 5/25/19.
 * 346. Moving Average from Data Stream
 *Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

 Example:

 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAveragefromDataStream346 {

    private Queue<Integer> queue;
    private double sum = 0;
    private int size;

    //constructor same name, no return type
    public MovingAveragefromDataStream346(int size) {
        queue = new LinkedList<>();
        this.size = size;

    }

    public double next(int val) {
        if(queue.size() == size) {
            sum -= queue.remove();
        }
        sum += val;
        queue.offer(val);
        return sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAveragefromDataStream346 m = new MovingAveragefromDataStream346(3);
        m.next(1);
        m.next(2);
        m.next(3);
        m.next(4);
        m.next(5);
        double param = m.next(9);
        System.out.println(param);
    }
}
