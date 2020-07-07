public class _52_NQueensII {
    class Solution {
        int count;
        public int totalNQueens(int n) {
            if (n < 0) return 0;
            dfs(n, 0, 0, 0, 0);
            return count;
        }
        void dfs(int n, int row, int col, int pie, int na) {
            if (row == n) {
                count++;
                return;
            }
            int bits = (~(col | pie | na)) & ((1 << n) - 1);
            while (bits > 0) {
                int p = bits & -bits;
                bits = bits & (bits - 1);
                dfs(n, row + 1, col | p, (pie | p) << 1, (na | p) >> 1);
            }
        }
    }
}
