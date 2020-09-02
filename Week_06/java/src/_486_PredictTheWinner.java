/**
 * 第一遍：2020/09/02周三 ✅
 * 第二遍：2020/08/25周三
 * 第三遍：2020/08/25周五
 * 第四遍：2020/06/13周六
 * 第一次遇到这个题目，一点思路都没有，递归的方法都没有想到，我的天。
 * 下次要画递归树找规律。
 */
class _486_PredictTheWinner {
    public boolean PredictTheWinner(int[] nums) {
        // f(i, j) 表示在[i, j]上当前玩家与另一玩家分数之差的最大值
        // f(i, j) = max(nums[i] - f(i + 1, j), nums[j] - f(i, j - 1));
        // i in [0, n - 1] j in [0, n - 1]
        // i == j 时 f(i, j) = nums[i]
        if (nums == null || nums.length == 0) return false;
        final int n = nums.length;
        int[] dp = new int[n];
        System.arraycopy(nums, 0, dp, 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}