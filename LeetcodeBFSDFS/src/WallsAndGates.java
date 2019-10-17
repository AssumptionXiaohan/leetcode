import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/16.
 */
public class WallsAndGates {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) bfs(rooms, i, j);
            }
        }
    }

    private void bfs(int[][] rooms, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
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
                    //不是墙且不是gate的时候才可以走
                    if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && !visited[x][y] && rooms[x][y] != 0 && rooms[x][y] != -1) {
                        rooms[x][y] = Math.min(rooms[x][y], length);
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
                size--;
            }
        }
    }
}
