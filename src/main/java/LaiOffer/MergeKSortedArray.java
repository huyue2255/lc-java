package LaiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuehu on 9/12/20.
 * Time: O(n*k*logk)
 */
public class MergeKSortedArray {
    static class Entry {
        // the row number
        int x;
        // the column number
        int y;
        // the corresponding value
        int value;

        Entry(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    static class MyComparator implements Comparator<Entry> {
        @Override
        public int compare(Entry e1, Entry e2) {
            if (e1.value == e2.value) {
                return 0;
            }
            return e1.value < e2.value ? -1 : 1;
        }

    }
    public int[] merge(int[][] arrayOfArrays) {
        // Assumptions: arrayOfArrays is not null, none of the array is null either.
        PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>(11, new MyComparator());
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            int[] array = arrayOfArrays[i];
            length += array.length;
            if (array.length != 0) {
                // we use two index to record the position of each element;
                // the index of array in the arrayOfArrays
                // the index of the element in the array
                minHeap.offer(new Entry(i,0,array[0]));
            }
        }
        int[] result = new int[length];
        int cur = 0;
        while (!minHeap.isEmpty()) {
            Entry tmp = minHeap.poll();
            result[cur++] = tmp.value;
            System.out.println("tmp.value" + tmp.value);
            if (tmp.y + 1 < arrayOfArrays[tmp.x].length) {
                // reuse the same Entry object but advance the index by 1.
                tmp.y++;
                tmp.value = arrayOfArrays[tmp.x][tmp.y];
                System.out.println("tmp.value next"+ tmp.value);
                minHeap.offer(tmp);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3,4},{2,3,4,5},{1,2}};
        MergeKSortedArray m = new MergeKSortedArray();
        System.out.println(Arrays.toString(m.merge(test)));
    }
}
