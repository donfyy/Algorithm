/**
 * 第一遍：2020/07/20周一 ✅
 * 第二遍：2020/07/20周一
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _115_DistinctSequences {
    public int numDistinct(String s, String t) {
        //f(i, j) t[0, i-1]在s[0, j - 1]中出现的个数
        //if (t[i - 1] == s[j - 1]) f(i, j) = f(i - 1, j - 1) + f (i, j - 1)
        //else f(i, j) = f(i, j - 1)
       int m = t.length();
       int n = s.length(); 
       int[][] dp = new int[m + 1][n + 1];
       for (int j = 0; j <= n; j++) {
           dp[0][j] = 1;
       }
       for (int i = 1; i <= m; i++) {
           for (int j = 1; j <= n; j++) {
               if (t.charAt(i - 1) == s.charAt(j - 1)) {
                   dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
               } else {
                   dp[i][j] = dp[i][j - 1];
               }
           }
       }
       return dp[m][n];
    }
}