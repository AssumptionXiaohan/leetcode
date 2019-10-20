import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/17.
 */
public class NQueensII {
    private int totalNQueens;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        totalNQueens = 0;
        helper(board, 0);
        return totalNQueens;
    }

    private void helper(char[][] board, int row) {
        if (row == board.length) {
            totalNQueens++;
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isValid(board, row, col)) {
                board[row][col] = 'Q';
                helper(board, row + 1);
                //backtracking
                board[row][col] = '.';
            }

        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        //当前行和当前列不可以有Q
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == 'Q' || board[x][i] == 'Q') return false;
        }
        //两个斜边不可以有Q，toLeftIdx:往左边走的斜线的y-x常量
        int toLeftIdx = y - x;
        int toRightIdx = y + x;
        for (int i = 0; i < board.length; i++) {
            if (i + toLeftIdx >= 0 && i + toLeftIdx < board.length && board[i][i + toLeftIdx] == 'Q') return false;
            if (toRightIdx - i >= 0 && toRightIdx - i < board.length && board[i][toRightIdx - i] == 'Q') return false;
        }
        return true;
    }

}
