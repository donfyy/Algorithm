/**
 * 第一遍：2020/07/20周二 ✅
 * 第二遍：2020/07/21周二
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 有了正则表达式匹配的基础这道题独立写出来了:)
 */
class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        //f(i, j)表示s前i个字符与p前j个字符是否完全匹配
        //if(p[j] == '*') f(i,j) = f(i - 1, j) || f(i, j - 1)
        //else if (p[j] == '?' || p[j] == s[i]) f(i, j) = f(i - 1, j - 1)
        //else f(i, j) = false
        //f(0, 0) = true
        //1 <= i <= m    1 <= j <= n
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}