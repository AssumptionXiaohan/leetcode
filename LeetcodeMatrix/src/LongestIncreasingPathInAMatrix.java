/**
 * Created by 79300 on 2019/10/14.
 */
public class LongestIncreasingPathInAMatrix {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 1;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int length = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, length);
            }
        }
        return max;
    }

    //return the LIP from matrix[i][j] to matrix[x][y]
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int length = 1 + dfs(matrix, x, y, m, n, cache);
                max = Math.max(max, length);
            }
        }
        cache[i][j] = max;
        return max;
    }
}
