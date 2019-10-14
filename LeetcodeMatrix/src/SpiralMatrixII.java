/**
 * Created by 79300 on 2019/10/13.
 * 是上一题的逆过程
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) return matrix;
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int current = 1;
        while (left < right && top < bottom) {
            for (int i = left; i < right; i++) {
                matrix[top][i] = current++;
            }
            for (int i = top; i < bottom; i++) {
                matrix[i][right] = current++;
            }
            for (int i = right; i > left; i--) {
                matrix[bottom][i] = current++;
            }
            for (int i = bottom; i > top; i--) {
                matrix[i][left] = current++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if (left == right & top == bottom) matrix[left][top] = current;
        return matrix;
    }
}
