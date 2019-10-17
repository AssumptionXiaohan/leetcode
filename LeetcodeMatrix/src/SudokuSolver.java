/**
 * Created by 79300 on 2019/10/16.
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9) return;
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int x, int y) {

        //找到下一个要填的位置
        while (x <= 8 && board[x][y] != '.') {
            if (y == 8) {
                x++;
                y = 0;
            } else {
                y++;
            }
        }
        //说明填完了
        if (x > 8) return true;

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, x, y, num)) {
                board[x][y] = (char) (num+'0');
                int nextRow = x + y / 8;//y到8的时候换到下一行
                int nextCol = (y + 1) % 9;//每次y++,如果到8的时候变成0
                boolean isValid = helper(board, nextRow, nextCol);
                if (isValid) return true;
                board[x][y] = '.';
            }
        }
        return false;
    }

    //检查board[row][col]的地方插入value值的话是否valid
    //检查这一行这一列和3x3的格子
    private boolean isValid(char[][] board, int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] - '0' == value || board[i][col] - '0' == value) return false;
        }
        //找到所在格子的左上角的位置
        int rowBegin = (row / 3) * 3;
        int colBegin = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowBegin + i][colBegin + j] - '0' == value) return false;
            }
        }
        return true;
    }
}
