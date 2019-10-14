/**
 * Created by 79300 on 2019/10/13.
 * 先把矩阵翻过来(projection)，再求transpose(也就是交换ij和ji)
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int length = matrix.length;
        for (int i = 0; i < length/2; i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }

        for(int i=0;i<length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
