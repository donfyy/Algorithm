/**
 * 第一遍：2020/07/07周二 ✅
 * 第二遍：2020/07/08周三 ✅
 * 第三遍：2020/07/08周四 ✅
 * 第四遍：2020/07/13周一 ✅
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
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
