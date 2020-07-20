/**
 * 第一遍：2020/07/19周日 ✅
 * 第二遍：2020/07/20周一 ✅
 * 第二遍花了近2个小时，奥利给，不要死磕，不顺的时候直接阅读题解去理解和学习。
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _312_BurstBalloons {
    public int maxCoins(int[] nums) {
        //最终状态：(0, n + 2)之间的[1, n]气球都被戳破
        //如何达到最终状态：在(0..n)之间选择任意一个气球k戳破
        //k未被戳破之前的状态(0..k)与(k, n)两个区间的气球都被戳破了
        //状态表示：f(i, j)表示(i, j)之间的气球都被戳破时能够获得硬币的最大数量
        //状态转移：f(i, j) = max(v[k] * v[i]* v[j] + f(i, k) + f(k, j))
        //边界条件：if (i >= j - 1) f(i, j) = 0
        // 0 <= i <= n - 1    2 <= j <= n + 1
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] nums1 = new int[n + 2];
        System.arraycopy(nums, 0, nums1, 1, n);
        nums1[0] = nums1[n + 1] = 1;

        int[][] dp = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + nums1[i] * nums1[k] * nums1[j] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }
}