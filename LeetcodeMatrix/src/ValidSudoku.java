/**
 * Created by 79300 on 2019/10/16.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return false;

        //行
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (row[num]) return false;
                    else row[num] = true;
                }
            }
        }
        //列
        for (int i = 0; i < 9; i++) {
            boolean[] column = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (column[num]) return false;
                    else column[num] = true;
                }
            }
        }
        //3x3子矩阵
        for (int i = 0; i < 9; i++) {

        }
    }
}
