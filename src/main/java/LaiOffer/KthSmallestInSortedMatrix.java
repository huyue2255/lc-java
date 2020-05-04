package LaiOffer;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yuehu on 5/2/20.
 * Assumptions:
 * 1) matrix is not null, N * M where N > 0 AND M > 0
 * 2) k > 0 and k < N * M
 */
public class KthSmallestInSortedMatrix {
    static class Cell {
        public int row;
        public int col;
        public int value;
        public Cell(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        //best first search, need a minheao on the value of each cells
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        // all the generated cells will be marked true,
        // to avoid being generated more than once
        boolean[][] visited = new boolean[rows][columns];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        //iterate k-1 rounds, and Best First Search the smallest k-1 cells.
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            // the neighbor cell will be inserted back to minHeap only if
            // 1. it is not out of boundary
            // 2. it hac not been generated before
            // Because for each cell it could be generatedd twice
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.col]) {
                minHeap.offer(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
                visited[cur.row + 1][cur.col] = true;
            }

            if (cur.col + 1 < columns && !visited[cur.row][cur.col + 1]) {
                minHeap.offer(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
                visited[cur.row][cur.col + 1] = true;
            }
        }
        return minHeap.peek().value;
    }

    public static void main(String[] args) {
        int[][] res = {{1,2,3},{15,16,17},{29,30,311}};
        KthSmallestInSortedMatrix s = new KthSmallestInSortedMatrix();
        System.out.println(s.kthSmallest(res,8));
    }
}
