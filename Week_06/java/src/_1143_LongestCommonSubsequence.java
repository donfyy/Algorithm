/**
 * 第一遍：2020/06/22周二 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _1143_LongestCommonSubsequence {
    //时间O(m * n)  空间O((m+1)*(n+1)
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];//好聪明啊
        for (int i = 1; i <= m; i++) {
            char c = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (c == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}