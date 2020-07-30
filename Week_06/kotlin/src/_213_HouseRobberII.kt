class _213_HouseRobberII_ {
    fun rob(nums: IntArray): Int {
        //[0, n - 2] [1, n - 1]
        if (nums.isEmpty()) {
            return 0
        }
        val n = nums.size
        return if (n == 1) nums[0] else rob(nums, 0, n - 2).coerceAtLeast(rob(nums, 1, n - 1))
    }

    fun rob(nums: IntArray, start: Int, end: Int): Int {
        //f(i) = max(f(i - 1), nums[i] + f(i - 2))
        var leftPreceding = 0
        var left = 0
        for (i in start..end) {
            val dp = left.coerceAtLeast(nums[i] + leftPreceding)
            leftPreceding = left
            left = dp
        }
        return left
    }
}