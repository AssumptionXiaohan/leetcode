/**
 * Created by 79300 on 2019/10/17.
 * 先把边界的O和边界O连通的O都变成*，然后把剩下的O变成X
 * 最后把*翻转回O
 */
public class SurroundedRegions {

    private static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;

        //第一列和最后一列
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][board[0].length - 1] == 'O') dfs(board, i, board[0].length - 1);
        }

        //第一行和最后一行
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') dfs(board, 0, i);
            if (board[board.length - 1][i] == 'O') dfs(board, board.length - 1, i);
        }

        //把矩阵里的O换成X,*换成O
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] != 'O') return;
        board[i][j] = '*';

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            dfs(board, x, y);
        }
    }
}
