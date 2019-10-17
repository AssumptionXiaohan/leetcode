/**
 * Created by 79300 on 2019/10/16.
 * 重点在于计算3x3方格中的数字在整体数独中的index
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
        for (int box = 0; box < 9; box++) {
            boolean[] oneBox = new boolean[10];
            for(int row=0;row<3;row++){
                for(int col=0;col<3;col++){
                    if(board[row+3*(box/3)][col+3*(box%3)]!='.'){
                        int num = board[row+3*(box/3)][col+3*(box%3)] -'1';
                        if(oneBox[num]) return false;
                        else oneBox[num] = true;
                    }
                }
            }
        }
        return true;
    }
}
