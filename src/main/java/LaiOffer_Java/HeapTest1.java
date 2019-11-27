package LaiOffer_Java;

import java.util.PriorityQueue;

/**
 * Created by yuehu on 8/24/19.
 */
public class HeapTest1 {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(3);
        minHeap.offer(13);
        minHeap.offer(4);
        minHeap.offer(2);
        minHeap.offer(89);

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }

    }
}
