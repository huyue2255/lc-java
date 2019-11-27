package MarixArray;

/**
 * Created by yuehu on 5/26/19.
 * 566. Reshape the Matrix
 * 知识点： index / 列数 = 所在行数， index % 列数 = 所在列数 （只跟列数相关）
 * n MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its original data.

 You're given a matrix represented by a two-dimensional array, and two positive integers r and c
 representing the row number and column number of the wanted reshaped matrix, respectively.

 The reshaped matrix need to be filled with all the elements of the original matrix in the same
 row-traversing order as they were.

 If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
 Otherwise, output the original matrix.

 Example 1:

 Input:
 nums =
 [[1,2],
 [3,4]]
 r = 1, c = 4
 Output:
 [[1,2,3,4]]

 Explanation:
 The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 fill it row by row by using the previous list.
 */
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if(nums.length == 0 || nums.length * nums[0].length != r * c) {
            return nums;
        }
        int i = 0;
        for(int[] row : nums) {
            for(int num : row) {
                res[i/c][i%c] = num;
                i++;
            }
        }
        return  res;
    }


}
