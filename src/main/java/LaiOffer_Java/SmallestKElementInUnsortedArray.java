package LaiOffer_Java;

import java.util.*;

/**
 * Created by yuehu on 8/22/19.
 * A is not null
 * K is >= 0 and smaller than or equal to size of A
 * A = {3,4,1,2,5}, k = 3, output {1,2,3}
 */
public class SmallestKElementInUnsortedArray {
    //impl with minHeap
    //Time: O((n+k)log n)  Space:O(n)
    public static int[] smallestKElementsNHeap(int[] array, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < array.length; i++) {
            minHeap.offer(array[i]);
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }
        return result;
    }

    //impl with maxHeap
    //Time: O((n+k)log k)  Space:O(k)
    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) return 0;
            return o1 > o2 ? -1 : 1;
        }
    }

    private static int[] toArray(Queue<Integer> q) {
        int[] res = new int[q.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = q.poll();
        }
        return res;
    }

    public static int[] smallestKElementsKHeap(int[] array, int k) {
        if (k == 0) {
            return new int[0];
        }

//        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k,new MyComparator());
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if (array[i] < maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        return toArray(maxHeap);

    }

    public static void main(String[] args) {
        int[] src = {2,1,4,33,22};
        int[] src1 = {2,4,33,22,0};
        SmallestKElementInUnsortedArray s = new SmallestKElementInUnsortedArray();
        int[] result = s.smallestKElementsKHeap(src,3);
        int[] result1 = s.smallestKElementsNHeap(src1,3);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));


    }
}
