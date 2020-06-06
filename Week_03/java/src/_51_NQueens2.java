import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 按列dfs的解法
 */
class _51_NQueens2 {
    private int mQueens[];
    private boolean mRows[];
    private boolean mDales[];
    private boolean mHills[];
    private int mN;

    private List<List<String>> mRet;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return Collections.emptyList();
        }

        mN = n;
        mQueens = new int[n];
        mRows = new boolean[n];
        mDales = new boolean[2 * n];
        mHills = new boolean[2 * n];

        mRet = new LinkedList<>();
        dfs(0);
        return mRet;
    }

    void dfs(int col) {
        if (col == mN) {
            generateSolution();
            return;
        }
        for (int row = 0; row < mN; row++) {
            if (isNotUnderAttack(row, col)) {
                placeQueen(row, col);
                dfs(col + 1);
                removeQueen(row, col);
            }
        }
    }

    boolean isNotUnderAttack(int row, int col) {
        return !mRows[row] && !mDales[row - col + mN] && !mHills[row + col];
    }

    void placeQueen(int row, int col) {
        mQueens[col] = row;
        mRows[row] = true;
        mDales[row - col + mN] = true;
        mHills[row + col] = true;
    }

    void removeQueen(int row, int col) {
        mQueens[col] = 0;
        mRows[row] = false;
        mDales[row - col + mN] = false;
        mHills[row + col] = false;
    }

    void generateSolution() {
        List<String> ans = new ArrayList<>(mN);
        StringBuilder sb = new StringBuilder();
        int[] cols = new int[mN];
        /*for (int col = 0; col < mN; col++) {
            int row = mQueens[col];
                cols[row] = col;
        }*/
        for (int row = 0; row < mN; row++) {
            sb.delete(0, sb.length());

            for (int col = 0; col < mN; col++) {
                //sb.append(col == cols[row] ? "Q":".");
                sb.append(col == mQueens[row] ? "Q" : ".");
            }

            ans.add(sb.toString());
        }

        mRet.add(ans);
    }
}