/**
 * Created by 79300 on 2019/10/13.
 * 见pad笔记 一言难尽
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) firstColumnZero = true;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) firstRowZero = true;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //检查第一行第一列的标记，把对应的行和列置为0
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) matrix[i][j] = 0;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < matrix.length; j++) matrix[j][i] = 0;
            }
        }

        //check origin matrix中第一行和第一列是否有0，如果有把第一行第一列全置为0
        if (firstRowZero) {
            for (int i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;
        }
        if (firstColumnZero) {
            for (int i = 0; i < matrix.length; i++) matrix[i][0] = 0;
        }
    }
}
