/**
 * Created by 79300 on 2019/10/13.
 */
public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0 || B == null || B.length == 0 || B[0].length == 0)
            return new int[0][0];
        int row = A.length;
        int column = B[0].length;
        int medium = A[0].length;
        int[][] result = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int sum = 0;
                for (int k = 0; k < medium; k++) {
                    sum = sum + A[i][k] * B[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
