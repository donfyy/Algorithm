/**
 * 第一遍：2020/08/20周四 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _529_Minesweeper {
    int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            dfs(board, i, j);
        }

        return board;
    }

    void dfs(char[][] board, int i, int j) {
        int count = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length) {
                if (board[x][y] == 'M') {
                    count++;
                }
            }
        }
        if (count > 0) {
            board[i][j] = (char) (count + '0');
            return;
        }
        board[i][j] = 'B';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'E') {
                dfs(board, x, y);
            }
        }
    }
}