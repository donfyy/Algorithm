class _486_RecurWithMemo {
    fun PredictTheWinner(nums: IntArray): Boolean {
        if (nums.isEmpty()) return false;
        val n = nums.size
        val memo = Array(n) { IntArray(n) }
        fun dp(i: Int, j: Int): Int { // 返回值表示当前玩家赢过另一玩家的分数
            return when {
                i == j -> nums[i]
                memo[i][j] != 0 -> memo[i][j]
                else -> maxOf(nums[i] - dp(i + 1, j), nums[j] - dp(i, j - 1)).apply { memo[i][j] = this }
            }
        }
        return dp(0, n - 1) >= 0
    }
}

class _486_Dp {
    fun PredictTheWinner(nums: IntArray): Boolean {
        // f(i, j) 闭区间[i, j]上先手玩家与另一玩家的分数之差
        if (nums.isEmpty()) return false;
        val n = nums.size
        val dp = IntArray(n) { nums[it] }
        for (i in n - 2 downTo 0) {
            for (j in i + 1 until n) {
                dp[j] = maxOf(nums[i] - dp[j], nums[j] - dp[j - 1])
            }
        }
        return dp[n - 1] >= 0
    }
}