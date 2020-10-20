package LaiOffer_Java;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuehu on 8/24/19.
 */
public class Cell_Comparator {
    static class Cell {
        public int row;
        public int col;
        public int value;
        public Cell(int row, int col, int value) {
            this.row = row;;
            this.col = col;
            this.value = value;
        }
    }

    static class MyComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            if (c1.value == c2.value) {
                return 0;
            }
            return c1.value < c2.value ? 1: -1;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(1,new MyComparator());
        Cell c1 = new Cell(0,0,28);
        Cell c2 = new Cell(0,0,56);
        Cell c3 = new Cell(0,0,59);

        minHeap.offer(c1);
        minHeap.offer(c2);
        minHeap.offer(c3);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll().value);//5,28,56
        }
    }
}
