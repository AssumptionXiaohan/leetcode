/**
 * Created by 79300 on 2019/10/16.
 */
public class SmallestRectangleEnclosingBlackPixels {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int top, bottom, left, right;

    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0 || image[0].length == 0) return 0;
        top = x;
        bottom = x;
        left = y;
        right = y;
        dfs(image, x, y);
        return (bottom - top+1) * (right - left+1);
    }

    private void dfs(char[][] image, int i, int j) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) return;
        if (image[i][j] != '1') return;
        image[i][j] = 0;
        top = Math.min(top, i);
        bottom = Math.max(bottom, i);
        left = Math.min(left, j);
        right = Math.max(right, j);

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(image, x, y);
        }
    }
}
