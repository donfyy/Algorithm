/**
 * 第一遍：2020/07/18周六 ✅
 * 第二遍：2020/07/16周四
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        int m = s1.length();
        int n = s2.length();
        if (s3.length() != m + n) return false;
        //f(i, j)表示s1前i个字符与s2前j个字符可以交错组成s3前i+j个字符
        //f(i, j) = (f(i - 1, j) && s1[i - 1] == s3[i - 1 + j]) || (f(i, j - 1) && s2[j - 1] == s3[i + j - 1])
        //f(0, 0) = true
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(k);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(k));
                }
            }
        }
        return dp[n];
    }
}