/**
 * Created by 79300 on 2019/6/29.
 * 空间开销比较大的思想：copy一个二维数组用来保存原来的值
 * 改进后的算法：
 * 因为只有0、1两种状态，我们新建两种状态-1、2来表示这个cell从1变成0、从0变成1
 * 这样既可以在更改下一个值的时候读取到已经被更改的值的原来数据
 * 也可以在最后重新遍历的时候全部改回0和1状态(即要return的结果)
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        //更新状态
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                updateStatus(board, row, column);
            }
        }
        //修改成只有0和1
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] <= 0) board[row][column] = 0;
                else board[row][column] = 1;
            }
        }
    }

    //更新某个点的状态
    private void updateStatus(int[][] board, int row, int column) {
        int count_alive = 0;
        //计算八个邻居有多少是活的
        if (exist(board, row - 1, column - 1) && isalive(board, row - 1, column - 1)) count_alive++;
        if (exist(board, row - 1, column) && isalive(board, row - 1, column)) count_alive++;
        if (exist(board, row - 1, column + 1) && isalive(board, row - 1, column + 1)) count_alive++;
        if (exist(board, row, column - 1) && isalive(board, row, column - 1)) count_alive++;
        if (exist(board, row, column + 1) && isalive(board, row, column + 1)) count_alive++;
        if (exist(board, row + 1, column - 1) && isalive(board, row + 1, column - 1)) count_alive++;
        if (exist(board, row + 1, column) && isalive(board, row + 1, column)) count_alive++;
        if (exist(board, row + 1, column + 1) && isalive(board, row + 1, column + 1)) count_alive++;
        //根据规则改变自己的状态值
        if (board[row][column] == 0 && count_alive == 3) board[row][column] = 2;
        if (board[row][column] == 1 && (count_alive < 2 || count_alive > 3))
            board[row][column] = -1;
    }

    //判断某个点是否存在于二维数组中
    private boolean exist(int[][] board, int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board[0].length;
    }

    //判断某个细胞是否活着
    private boolean isalive(int[][] board, int row, int column) {
        return board[row][column] == -1 || board[row][column] == 1;
    }

    public static void main(String[] args) {
        int[][] broad = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        GameOfLife gl = new GameOfLife();
        gl.gameOfLife(broad);
        for (int i = 0; i < broad.length; i++) {
            for (int j = 0; j < broad[0].length; j++) {
                System.out.print(broad[i][j]);
            }
            System.out.println();
        }
    }
}
