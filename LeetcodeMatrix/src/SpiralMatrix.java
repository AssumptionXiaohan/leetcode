import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/13.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        while (left < right && top < bottom) {
            for(int i=left;i<right;i++){
                result.add(matrix[top][i]);
            }
            for(int i=top;i<bottom;i++){
                result.add(matrix[i][right]);
            }
            for(int i=right;i>left;i--){
                result.add(matrix[bottom][i]);
            }
            for(int i=bottom;i>top;i--){
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        if(top==bottom+1||left==right+1) return result;
        if(top==bottom){
            for(int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
        }else if (left==right){
            for(int i=top;i<=bottom;i++){
                result.add(matrix[i][left]);
            }
        }
        return result;
    }
}
