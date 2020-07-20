/**
 * 第一遍：2020/07/20周一 ✅
 * 第二遍：2020/07/20周一
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        //f(i, j)表示word1前i个字符组成的字符串转换成word2前j个字符组成的字符串所使用的最少的操作数
        //if (word1[i - 1] == word2[j - 1]) f(i, j) = f(i - 1, j - 1)
        // else f(i, j) = min(f(i - 1, j) + 1, f(i, j - 1) + 1, f(i - 1, j - 1))
        // 1 <= i <= m      1 <= j <= n
        if (word1 == null || word2 == null) {
            return -1;
        }
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}