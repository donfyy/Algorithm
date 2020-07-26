fun splitArray(nums: IntArray, m: Int): Int {
    //f(i, j) 表示将前i个数分割成j个子数组的最小最大值
    //f(i, j) = min(max(f(k, j - 1), sum(k+1, i))) for k in (0, i)
    //i < j全是不合法的状态，将这些状态初始化为Integer.MAX_VALUE
    //f(0, 0) = 0 因为f(1, 1)要从f(0, 0)转移过来
    if (nums.isEmpty() || nums.size < m) return 0
    val n = nums.size
    val dp = Array(n + 1) { IntArray(m + 1) { Integer.MAX_VALUE } }
    dp[0][0] = 0
    val sum = IntArray(n + 1)
    for (i in 1..n) {
        sum[i] = sum[i - 1] + nums[i - 1]
    }
    for (i in 1..n) {
        for (j in 1..Math.min(i, m)) {
            for (k in 0 until i) {
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]))
            }
        }
    }
    return dp[n][m]
}

fun splitArrayWithBinarySearch(nums: IntArray, m: Int): Int {
    //子数组和的最大值在范围[max(nums), sum(nums)]
    //二分查找最大值
    //l = max(nums), r = sum(nums)
    //mid = (l + r) ushr 1
    //统计和小于等于mid的子数组的个数count
    //if (count > m) l = mid + 1 else r = mid
    //最终 return l
    if (nums.isEmpty() || nums.size < m) return 0
    val n = nums.size
    var l = nums[0].toLong()
    var r = l
    for (i in 1 until n) {
        r += nums[i]
        if (nums[i] > l) {
            l = nums[i].toLong()
        }
    }
    while (l < r) {
        val mid = (l + r) ushr 1
        var count = 1
        var s = 0L
        for (v in nums) {
            s += v
            if (s > mid) {
                s = v.toLong()
                count++
            }
        }
        if (count > m) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return l.toInt()
}