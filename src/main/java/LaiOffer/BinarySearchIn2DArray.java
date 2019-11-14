package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 11/9/19.
 * search in sorted matrix, each row of the matrix is sorted in ascending order,
 * and the first element of the row is equals to or larger than the last element
 *  of the previoud row.
 *  Return the position if the target is found, otherwise return {-1,-1}
 */
public class BinarySearchIn2DArray {
    public int[] searchI(int[][] matrix, int target) {
        int[] result = {-1,-1};
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = cols * rows - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] == target) {
                return new int[] {row, col};
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = {{1,2,3,4},{5,6,7,8},{9,10,11,12,13}};
        BinarySearchIn2DArray s = new BinarySearchIn2DArray();
        System.out.println(Arrays.toString(s.searchI(result,5)));
    }


}
