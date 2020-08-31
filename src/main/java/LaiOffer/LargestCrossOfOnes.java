package LaiOffer;

/**
 * Created by yuehu on 8/22/20.
 */
public class LargestCrossOfOnes {
    public int largest(int[][] matrix) {
        // Assumptions: matrix is not null, has size of N * M,
        // where N >= 0 and M >= 0.
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }

        // leftup records the longest possible length for left and up
        // arms ending at each cells in matrix.
        int[][] leftUp = leftUp(matrix, N, M);
        // rightDown records the longest possible length for left and up
        // arms ending at each cells in matrix
        int[][] rightDown = rightDown(matrix, N, M);
        // merge the two matrix by getting the min valuee for each cell,
        // and among all the cells get the max value.
        return merge(leftUp, rightDown, N, M);
    }

    // merge leftup and rightdown matrix into leftup,
    // the value of each cells is the min value of the corresponding cells
    // in the two matrix, also it returns the max value among all the cells
    // in the merged matrix
    private int merge(int[][] leftUp, int[][] rightDown, int N, int M) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; i++) {
                leftUp[i][j] = Math.min(leftUp[i][j], rightDown[i][j]);
                result = Math.max(result, leftUp[i][j]);
            }
        }
        return result;
    }

    private int[][] leftUp(int[][] matrix, int N, int M) {
        int[][] left = new int[N][M];
        int[][] up = new int [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 && j == 0) {
                        up[i][j] = 1;
                        left[i][j] = 1;
                    } else if (i == 0) {
                        up[i][j] = 1;
                        left[i][j] = 1 + left[i][j-1];
                    } else if (j == 0) {
                        left[i][j] = 1;
                        up[i][j] = 1 + up[i-1][j];
                    } else {
                        up[i][j] = up[i-1][j-1] + 1;
                        left[i][j] = left[i-1][j-1] + 1;
                    }
                }
            }
        }
        // merge left and up, return the merged matrix.
        merge(left, up, N, M);
        return left;
    }

    private int[][] rightDown(int[][] matrix, int N, int M) {
        int[][] right = new int[N][M];
        int[][] down = new int [N][M];
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1 && j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1;
                    } else if (i == N - 1) {
                        down[i][j] = 1;
                        right[i][j] = 1 + right[i][j-1];
                    } else if (j == M - 1) {
                        right[i][j] = 1;
                        down[i][j] = 1 + down[i-1][j];
                    } else {
                        right[i][j] = right[i-1][j-1] + 1;
                        down[i][j] = down[i-1][j-1] + 1;
                    }
                }
            }
        }
        // merge left and up, return the merged matrix.
        merge(down, right, N, M);
        return down;
    }

    public static void main(String[] args) {
        int[][] test = {{0,1,0,0,0}, {1,1,1,1,1}, {0,1,0,0,0}, {0,1,0,0,0},{0,1,0,0,0}};
        LargestCrossOfOnes s = new LargestCrossOfOnes();
        System.out.println(s.largest(test));

    }
}
