import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/06/06周六 ✅
 * 第二遍：2020/07/06周一 ✅
 * 第三遍：2020/07/08周三 ✅
 * 第四遍：2020/07/13周一 ✅
 * 第四遍：2020/06/27周六
 */
class _51_NQueens {
    class SolutionUsingBits {
        int[] queens;
        int n;
        List<List<String>> ret;
        public List<List<String>> solveNQueens(int n) {
            if (n < 1) return Collections.emptyList();
            queens = new int[n];
            this.n = n;
            ret = new LinkedList<>();
            dfs(0, 0, 0, 0);
            return ret;
        }

        void dfs(int row, int col, int pie, int na) {
            if (row == n) {
                generateSolution();
                return;
            }

            int bits = ~(col | pie | na) & ((1 << n) - 1);
            while (bits != 0) {
                int pos = bits & -bits;
                queens[row] = pos;
                dfs(row + 1, col | pos, (pie | pos) << 1, (na | pos) >> 1);
                bits = bits & (bits - 1);
            }
        }

        void generateSolution() {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>(n);
            for (int row : queens) {
                for (int i = 0; i < n; i++) {
                    sb.append((row & 1) == 1 ? 'Q' : '.');
                    row >>= 1;
                }
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
            ret.add(list);
        }
    }
    //i处的值表示i行皇后的列号
    private int[] mQueens;
    //i处的值表示i列是否被攻击了
    private boolean[] mCols;
    //i处的值表示row-col+n的主对角线是否被攻击了
    private boolean[] mDales;
    //i处的值表示row+col的副对角线是否被攻击了
    private boolean[] mHills;
    private int mN;
    private List<List<String>> mRet;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        mN = n;
        mQueens = new int[n];
        mCols = new boolean[n];
        mDales = new boolean[2 * n];
        mHills = new boolean[2 * n];
        mRet = new LinkedList<>();

        //按行dfs
        dfs(0);

        return mRet;
    }

    void dfs(int row) {
        if (row == mN) {
            generateSolution();
            return;
        }

        for (int col = 0; col < mN; col++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                dfs(row + 1);
                removeQueen(row, col);
            }
        }
    }

    void placeQueen(int row, int col) {
        mQueens[row] = col;
        mCols[col] = true;
        mDales[row - col + mN] = true;
        mHills[row + col] = true;
    }

    void removeQueen(int row, int col) {
        mQueens[row] = 0;
        mCols[col] = false;
        mDales[row - col + mN] = false;
        mHills[row + col] = false;
    }

    boolean isNotUnderAttack(int row, int col) {
        return !mCols[col] && !mDales[row - col + mN] && !mHills[row + col];
    }

    void generateSolution() {
        List<String> ans = new ArrayList<>(mN);
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < mN; row++) {
            sb.delete(0, sb.length());
            for (int col = 0; col < mN; col++) {
                sb.append((col == mQueens[row]) ? "Q" : ".");
            }

            ans.add(sb.toString());
        }

        mRet.add(ans);
    }

    /**
     * 使用一个二维字符数组，按列dfs摆放皇后
     */
    public List<List<String>> solveNQueens2(int n) {
        //定义一个二维字符数组board
        char[][] board = new char[n][n];
        //将board中的每一个字符初始化为'.'
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        //按列dfs
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            //将皇后摆放到了最后一列，记录摆放后的棋盘
            res.add(construct(board));
            return;
        }

        //在该列尝试逐行摆放皇后
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                //如果i行可以摆放皇后，则将皇后摆放在i,colIndex处
                board[i][colIndex] = 'Q';
                //开始尝试在colIndex+1处摆放皇后
                dfs(board, colIndex + 1, res);
                //将摆放在i, colIndex处的皇后拿走，尝试在i+1，colIndex处摆放皇后
                board[i][colIndex] = '.';
            }
        }
    }

    private boolean validate(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                //检查x,y是否被i,j吃掉了
                if (board[i][j] == 'Q' && (x + j == y + i/*主对角线*/ || x + y == i + j/*副对角线*/ || x == i)/*同一行*/)
                    return false;
            }
        }

        return true;
    }

    //将二维字符数组按行转换成字符串列表
    private List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}