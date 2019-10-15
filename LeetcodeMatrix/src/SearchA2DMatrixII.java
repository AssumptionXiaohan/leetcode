/**
 * Created by 79300 on 2019/10/15.
 * trick：从右上角的元素开始搜索，每次都可以除掉一行或者一列
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) return true;
            else if (target > matrix[row][col]) row++;
            else col--;
        }
        return false;
    }
}
