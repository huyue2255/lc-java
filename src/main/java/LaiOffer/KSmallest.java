package LaiOffer;

import LaiOffer_Java.SmallestKElementInUnsortedArray;

import java.util.*;

/**
 * Created by yuehu on 1/25/20.
 * find the smallest element in an unsorted array
 * Assumption: 1) array is not null. 2) k >= 0 and k <= array.length
 */
public class KSmallest {
    private static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1.equals(o2)) return 0;
            return o1 > o2 ? -1 : 1;
        }
    }

    private static int[] toArray(Queue<Integer> q) {
        int[] res = new int[q.size()];
        int k = q.size();
        for (int i = k - 1; i >= 0; i--) {
            res[i] = q.poll();
        }
        return res;
    }

    //Method 1: K sized max heap
    public static int[] kSmallestI (int[] array, int k) {
        //handle all possible corner cases at the very beginning
        if (array.length == 0 || k == 0) {
            return new int[0];
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(k, new MyComparator());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                // offer the first k elements into max heap
                // Notice: if you want to utilize heapify(), the only thing you can do
                // is to call a certain constructor of PriorityQueue
                maxHeap.offer(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                // for the other elements, only offer it into the max heap
                // if it is smaller than the max value in the max heap.
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        return toArray(maxHeap);
    }

    //Method 2: N size min heap
    public static int[] kSmallestII(int[] array, int k) {
        Queue<Integer> minHeap =  new PriorityQueue<Integer>();
        for (int i = 0; i < array.length ; i++) {
            minHeap.offer(array[i]);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }

    // Method 3: Quick Partition worst case O(n^n), average O(n)
    public static int[] kSmallestIII(int[] array, int k) {
        //handle corner case at beginning
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        //quickselect to find the kth smallest element.
        //after calling this method, the first k elements in the array are
        //the k smallest ones(but not sorted)
        quickSelect(array, 0, array.length - 1, k - 1);
        //copy out the first k elements and sort them
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);
        return result;
    }

    private static void quickSelect(int[] array, int left, int right, int target) {
        //like quick sort, we need to do the partition using pivot value
        int mid = partition(array, left, right);
        //unlike quick sort, we only need to do quickselect on at most one partition
        //if the pivot is already the kth smallest element, we can directly return.
        if (mid == target) {
            return;
        } else if (target < mid) {
            quickSelect(array, left, mid - 1, target);
        } else {
            quickSelect(array, mid + 1, right, target);
        }

    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int start = left;
        int end = right - 1;
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if(array[end] >= pivot) {
                end--;
            } else {
                swap(array,start++, end--);
            }
        }
        swap(array, start, end);
        return start;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = array[temp];
    }

    public static void main(String[] args) {
        int[] src = {2,1,4,33,22,23,24,25};
        int[] src1 = {2,4,33,22,0};
        KSmallest s = new KSmallest();
        int[] result = s.kSmallestI(src,4);
        int[] result1 = s.kSmallestII(src,4);

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }
}
