package LaiOffer_Java;

import java.util.PriorityQueue;

/**
 * Created by yuehu on 8/24/19.
 */
public class Cell_Comparable {

    static class Cell implements Comparable<Cell> {
        public int row;
        public int col;
        public int value;
        public Cell(int row, int col,int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        @Override
        public int compareTo(Cell another) {
            if (this.value == another.value) {
                return 0;
            }
            return this.value < another.value ? -1 : 1; //minHeap
//            return this.value < another.value ? 1 : -1; //maxHeap
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>();
        Cell c1 = new Cell(0,0,2);
        Cell c2 = new Cell(0,0,56);
        Cell c3 = new Cell(0,0,12);
        Cell c4 = new Cell(0,0,1);
        minHeap.offer(c1);
        minHeap.offer(c2);
        minHeap.offer(c3);
        minHeap.offer(c4);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll().value);//1,2,12,56
        }
    }
}
