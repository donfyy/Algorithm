/**
 * 第一遍：2020/08/11周二 ✅
 * 第二遍：2020/08/10周二
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 菜。。
 */
class _130_SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m < 3) return;
        int n = board[0].length;
        if (n < 3) return;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}