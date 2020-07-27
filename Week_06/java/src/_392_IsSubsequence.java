/**
 * 第一遍：2020/07/27周一 ✅
 * 第二遍：2020/07/26周日
 * 第三遍：2020/07/27周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        int m = s.length();
        int n = t.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }
        return i == m;
    }

    class SolutionDp {
        /*
        如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
        在这种情况下，你会怎样改变代码？
         */
        public boolean isSubsequence(String s, String t) {
            //f(i,j)表示从i开始往后字符j出现的位置
            //f(i,j) = i 如果i处的字符和j相等
            //i in [0, m] f(m, j) = m  j in [0, 25]
            if (s == null || t == null) return false;
            int m = t.length();
            int n = s.length();
            int[][] dp = new int[m + 1][26];
            for (int j = 0; j < 26; j++) {
                dp[m][j] = m;
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < 26; j++) {
                    if (t.charAt(i) == j + 'a') {
                        dp[i][j] = i;
                    } else {
                        dp[i][j] = dp[i + 1][j];
                    }
                }
            }
            int i = 0;
            for (int k = 0; k < n; k++) {
                int idx = dp[i][s.charAt(k) - 'a'];
                if (idx == m) {
                    return false;
                }
                i = idx + 1;
            }
            return true;
        }
    }
}