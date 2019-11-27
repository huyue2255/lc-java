package LaiOffer_Java;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuehu on 8/24/19.
 */
public class Comparable_Comparator {
    static class ReverseComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1.equals(i2)) {
                return 0;
            }
            return i1 < i2 ? 1 : -1;
        }

        public static void main(String[] args) {
//            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new ReverseComparator());
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            maxHeap.offer(4);
            maxHeap.offer(45);
            maxHeap.offer(5);
            maxHeap.offer(1);
            maxHeap.offer(100);
            maxHeap.offer(6);

            while (!maxHeap.isEmpty()) {
                System.out.println(maxHeap.poll());
            }
        }
    }
}
