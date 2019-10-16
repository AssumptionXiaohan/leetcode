/**
 * Created by 79300 on 2019/10/15.
 * DFS的题
 */
public class WordSearch {
    private static final int dirs[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return word.equals("");
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(word, board, i, j, visited, 0)) return true;
                }
            }
        }
        return false;
    }

    //从ij出发是否能找到一条路径组成word
    public boolean dfs(String word, char[][] board, int i, int j, boolean[][] visited, int idx) {
        //word的最后一个char已经比较完毕 return true
        if (idx == word.length()) return true;
        //word所有的char还没有比较完但是board已经越界了，说明这条路径不符合要求
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        //当前的结点与idx的char不相等，这条路不对
        if (board[i][j] != word.charAt(idx)) return false;
        //当前结点被访问过了，不可以重复访问
        if (visited[i][j]) return false;

        visited[i][j] = true;

        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            //四个方向只要有一条能找到就返回true
            if (dfs(word, board, x, y, visited, idx + 1)) return true;
        }
        //遍历完ij之后的所有路径后，要把visited[i][j]重置为false，以便之前的结点还能走其他路径
        visited[i][j] = false;
        //说明四个方向都没找到 return false
        return false;
    }
}
