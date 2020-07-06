/**
 * 第一遍：2020/07/06周一 ✅
 * 第二遍：2020/07/03周五
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == '.') continue;//这里忘了判断是不是'.'..
                for (int k = 0; k < board[0].length; k++) {
                    if (k != j && board[i][k] == c) {
                        return false;
                    }
                    if (k != i && board[k][j] == c) {
                        return false;
                    }

                    int ki = i / 3 * 3 + k / 3;
                    int kj = j / 3 * 3 + k % 3;
                    if (ki != i && kj != j && board[ki][kj] == c) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}