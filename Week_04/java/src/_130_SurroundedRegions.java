import java.util.LinkedList;
import java.util.Queue;

/**
 * 第一遍：2020/08/11周二 ✅
 * 第二遍：2020/08/11周三 ✅
 * 第三遍：2020/07/18周六
 * 第三遍：2020/07/08周四
 * 菜。。
 */
class _130_SurroundedRegions {
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null) return;
        int m = board.length;
        if (m < 3) return;
        int n = board[0].length;
        if (n < 3) return;
        int[] borderRow = {0, m - 1};
        int[] borderCol = {0, n - 1};
        for (int i : borderRow) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int j : borderCol) {
            for (int i = 1; i < m - 1; i++) {
                if (board[i][j] == 'O') {
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

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        board[i][j] = '#';
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }

    class SolutionBfs {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void solve(char[][] board) {
            if (board == null) return;
            int m = board.length;
            if (m < 3) return;
            int n = board[0].length;
            if (n < 3) return;
            int[] borderRow = {0, m - 1};
            int[] borderCol = {0, n - 1};
            Queue<int[]> queue = new LinkedList<>();
            for (int i : borderRow) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'O') {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            for (int j : borderCol) {
                for (int i = 1; i < m - 1; i++) {
                    if (board[i][j] == 'O') {
                        queue.offer(new int[]{i, j});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] u = queue.poll();
                board[u[0]][u[1]] = '#';
                for (int[] dir : dirs) {
                    int i = u[0] + dir[0];
                    int j = u[1] + dir[1];
                    if (i >= 0 && i < m && j >= 0 && j < n && board[i][j] == 'O') {
                        queue.offer(new int[]{i, j});
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
    }
}