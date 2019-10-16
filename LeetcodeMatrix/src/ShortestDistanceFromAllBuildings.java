import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/15.
 * 对每一个1的点进行BFS
 * 同时计算totalDis(每一个0结点到所有1结点的距离)
 */
public class ShortestDistanceFromAllBuildings {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] totalDis = new int[grid.length][grid[0].length];
        int[][] reached = new int[grid.length][grid[0].length];
        int totalOnes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //每一个1的地方都开始一次bfs
                if (grid[i][j] == 1) {
                    totalOnes++;
                    bfs(grid, i, j, totalDis, reached);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < totalDis.length; i++) {
            for (int j = 0; j < totalDis[0].length; j++) {
                if (grid[i][j] == 0 && reached[i][j] == totalOnes) result = Math.min(result, totalDis[i][j]);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void bfs(int[][] grid, int i, int j, int[][] totalDis, int[][] reached) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int length = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            while (size > 0) {
                int[] current = queue.poll();
                for (int[] dir : dirs) {
                    int x = current[0] + dir[0], y = current[1] + dir[1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y] && grid[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                        //修改totalDis的距离,修改reached的值，xy被多reach了一次
                        totalDis[x][y] += length;
                        reached[x][y]++;
                    }
                }
                size--;
            }
        }
    }
}
