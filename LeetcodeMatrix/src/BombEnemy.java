/**
 * Created by 79300 on 2019/10/15.
 */
public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int rowCount = 0;
        int[] colCount = new int[n];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //水平方向记录rowCount
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowCount = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        if (grid[i][k] == 'E') rowCount++;
                    }
                }
                //垂直方向记录colCount[n]
                if (i == 0 || grid[i - 1][j] == 'W') {
                    //开始新的一段了，要重新计算rowCount和colCount 这里的段是按W来划分的
                    colCount[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        if (grid[k][j] == 'E') colCount[j]++;
                    }
                }
                //如果当前位置=0可以放置炸弹，计算炸死的敌人数量并更新result
                if (grid[i][j] == '0')
                    result = Math.max(result, rowCount + colCount[j]);
            }
        }
        return result;
    }
}
