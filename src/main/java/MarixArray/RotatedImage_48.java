package MarixArray;

import java.util.Arrays;

/**
 * Created by yuehu on 7/30/19.
 */
public class RotatedImage_48 {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] s = {{1,2,3},{4,5,6},{7,8,9}};
        RotatedImage_48 a = new RotatedImage_48();
        a.rotate(s);
        System.out.println(Arrays.toString(s[0]));
        System.out.println(Arrays.toString(s[1]));
        System.out.println(Arrays.toString(s[2]));

    }
}
