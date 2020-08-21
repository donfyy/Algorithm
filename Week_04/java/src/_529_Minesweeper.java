import java.util.LinkedList;

/**
 * 第一遍：2020/08/20周四 ✅
 * 第二遍：2020/08/20周五 ✅
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

    // 需要一个访问数组以防止点v被添加进队列多次
    class BFS {
        public char[][] updateBoard(char[][] board, int[] click) {
            int i = click[0], j = click[1];
            if (board[i][j] == 'M') {
                board[i][j] = 'X';
            } else {
                int m = board.length;
                int n = board[0].length;
                int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
                boolean[][] visited = new boolean[m][n];
                LinkedList<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] u = queue.poll();
                    i = u[0];
                    j = u[1];
                    int c = 0;
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'M') {
                            c++;
                        }
                    }
                    if (c != 0) {
                        board[i][j] = (char)(c + '0');
                    } else {
                        board[i][j] = 'B';
                        for (int[] dir : dirs) {
                            int x = i + dir[0];
                            int y = j + dir[1];
                            if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && board[x][y] == 'E') {
                                queue.offer(new int[]{x, y});
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
            return board;
        }
    }
}