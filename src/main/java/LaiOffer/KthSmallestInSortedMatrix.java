//package LaiOffer;
//
//import javafx.scene.control.Cell;
//
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
///**
// * Created by yuehu on 2/8/20.
// * Assumption:
// * 1). matric is not null , N*N where N > 0 and M >
// * 2). k > 0 and k <= N * M
// */
//public class KthSmallestInSortedMatrix {
//    static class Cell {
//        int row;
//        int column;
//        int value;
//
//        Cell(int row, int column, int value) {
//            this.row = row;
//            this.column = column;
//            this.value = value;
//        }
//    }
//    public int kthSmallest(int[][] matrix, int k) {
//        int rows = matrix.length;
//        int columns = matrix[0].length;
//        //Best First Search, need a minheap on the value of each cells
//        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
//            @Override
//            public int compare(Cell o1, Cell o2) {
//                if(o1.value == o2.value){
//                    return 0;
//                }
//                return o1.value < o2.value ? -1 : 1;
//            }
//        });
//        // all the generated cells will be marked true
//        //to avoid being generated more than once
//        boolean[][] visited = new boolean[rows][columns];
//
//    }
//
//}
