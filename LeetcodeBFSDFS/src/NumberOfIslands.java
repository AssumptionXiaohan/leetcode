/**
 * Created by 79300 on 2019/10/16.
 */
public class NumberOfIslands {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] != '1') return;
        grid[i][j] = '0';

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(grid, x, y);
        }
    }
}
