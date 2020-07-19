/**
 * 第一遍：2020/07/19周日 ✅
 * 第二遍：2020/07/19周日
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _312_BurstBalloons {
    public int maxCoins(int[] nums) {
//选一个气球戳破
//在开区间内戳破一个气球
//动作：戳破一个气球
//最后的状态：在0..n-1所有的气球都被戳破了
//上一步的状态: 某一个气球没有被戳破假设为k，则 k in 0..n-1
//f(i, j)戳破区间i..j内的所有气球能够得到的硬币的最大数量
//f(i, j) = max(v[k] * v[i + 1] * v[j - 1] + f(i, k) + f(k, j)) for k in (i, j)
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] nums1 = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            nums1[i] = nums[i - 1];
        }
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