/**
 * 第一遍：2020/07/20周一 ✅
 * 第二遍：2020/07/20周一
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _10_RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        //f(i, j)表示s'的前i个字符组成的字符串与p'的前j个字符组成的字符串是否匹配
        // 1 <= i <= m     1 <= j <= n
        //if (p[j - 1] == '*')
        //      if (p[j - 2] == s[i - 1] || p[j - 2] == '.')  dp[i][j] = dp[i][j - 2] || dp[i - 1][j]
        //      else                   dp[i][j] = dp[i][j - 2]
        //else if (p[j - 1] == s[i - 1] || p[j - 1] == '.')             dp[i][j] = dp[i - 1][j - 1]
        //else  dp[i][j] = false
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (isMatch(s, i, p, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (isMatch(s, i, p, j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    boolean isMatch(String s, int i, String p, int j) {
        if (i == 0) return false;
        return p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1);
    }
}