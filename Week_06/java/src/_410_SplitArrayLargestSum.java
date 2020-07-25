import java.util.Arrays;
/**
 * 第一遍：2020/07/25周五 ✅
 * 第二遍：2020/06/15周一
 * 第三遍：2020/06/21周日
 * 第四遍：2020/07/05周日
 */
class _410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        //数组长度为n，要分成m个非空连续子数组
        //第一次分割有 n - m + 1种，在区间[0, n - 1]选取i分割 [0, i] [i + 1, n - 1] i in [0, n - m]
        //剩下的区间[i + 1, n - 1]有 分割成 m - 1个非空连续子数组.
        //f(i, j)表示区间[i, j] m个子数组各自和的最小的最大值
        //f(i, j) = min(min(sum(i, k), f(k + 1, j))) for k in [i, j - m]
        //花了30分钟得到上面的分析结果
        //花了1个小时没理解题解，草
        //f(i, j)表示将数组前i个数分割为j段所能得到的最大连续子数组和的最小值
        //f(i, j) = min(max(f(i, k), sum(k + 1, j)) k in (0, i))
        //合法的状态是 i >= j, 不合法的状态，i < j 因为要求最小值，我们可以将不合法的状态初始化为最大值
        //f(0, 0) = 0      i in [1, n] j in [1, min(i, m)]
        if (nums == null || m < 0 || nums.length < m) return -1;
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]));
                }
            }
        }
        return dp[n][m];
    }
}