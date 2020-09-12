package LaiOffer;

import java.util.Arrays;

/**
 * Created by yuehu on 9/1/20.
 */
public class RotateMatrix {
    // Method 1: Split into levels and for each level split it into
    // four partitions
    public void rotate(int[][] matrix) {
        // Assumptions: matrix is not null and has size of N * N, N >= 0
        int n = matrix.length;
        if (n <= 1) {
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1,2,3}, {4,5,6}, {7,8,9}};
        RotateMatrix r = new RotateMatrix();
        System.out.println(Arrays.toString(test[0]));
        System.out.println(Arrays.toString(test[1]));
        System.out.println(Arrays.toString(test[2]));
        r.rotate(test);
        System.out.println("======");
        System.out.println(Arrays.toString(test[0]));
        System.out.println(Arrays.toString(test[1]));
        System.out.println(Arrays.toString(test[2]));
    }
}
