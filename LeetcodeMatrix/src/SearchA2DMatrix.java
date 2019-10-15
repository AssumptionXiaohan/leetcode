/**
 * Created by 79300 on 2019/10/15.
 * 直接当sorted array/list二分查找就可以
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix[0].length;
        int low = 0, high = matrix.length * n - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (matrix[mid / n][mid % n] == target) return true;
            else if (matrix[mid / n][mid % n] > target) high = mid;
            else low = mid;
        }
        if (matrix[low / n][low % n] == target || matrix[high / n][high % n] == target) return true;
        return false;
    }
}
