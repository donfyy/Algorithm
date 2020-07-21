/**
 * 第一遍：2020/07/20周一 ✅
 * 第二遍：2020/07/21周二 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        //f(i, j)表示s前i个字符与p前j个字符是否匹配
        //if (p[j] == '*')
        //                if (p[j - 1] == '.' || p[j - 1] == s[i]) f(i, j) = f(i - 1, j) || f(i, j - 2)
        //                else f(i, j) = f(i, j - 2)
        //else if (p[j] == '.' || p[j] == s[i]) f(i, j) = f(i - 1, j - 1)
        //else f(i, j) = false
        //f(0, 0) = true
        // 0 <= i <= m     1 <= j <= n
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (i > 0 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) {
                        dp[i][j] = dp[i - 1][j] || dp[i][j];
                    }
                } else if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}