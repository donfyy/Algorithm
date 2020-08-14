fun splitArray(nums: IntArray, m: Int): Int {
    //f(i, j)表示将数组的前i个数分割为j段得到的最大连续子数组和的最小值
    //将前k个数分割为j - 1 段，然后将第k+1到第i个数作为第j段
    //f(i, j) = min(max(f(k, j - 1), sub(k + 1, i))) k in [0, i - 1]
    //i < j 无意义的状态，初始化为最大值，不会对结果产生影响。
    //f(i, 1) = min(max(f(0, 0), sub(1, i))) f(0, 0) = 0
    val n = nums.size
    val dp = Array(n + 1) { LongArray(m + 1) { Long.MAX_VALUE } }
    dp[0][0] = 0
    val sum = LongArray(n + 1)
    for (i in 1..n) {
        sum[i] = sum[i - 1] + nums[i - 1]
    }
    for (i in 1..n) {
        for (j in 1..minOf(i, m)) {
            for (k in 0 until i) {
                dp[i][j] = minOf(dp[i][j], maxOf(dp[k][j - 1], sum[i] - sum[k]))
            }
        }
    }
    return dp[n][m].toInt()
}

fun splitArrayWithBinarySearch(nums: IntArray, m: Int): Int {
    //子数组和的最大值在范围[max(nums), sum(nums)]
    //二分查找最大值
    //l = max(nums), r = sum(nums)
    //mid = (l + r) ushr 1
    //统计和小于等于mid的子数组的个数count
    //if (count > m) l = mid + 1 else r = mid
    //最终 return l
    if (nums.isEmpty() || nums.size < m) {
        return 0
    }
    var l = 0L
    var r = 0L
    for (num in nums) {
        r += num
        if (num > l) {
            l = num.toLong()
        }
    }
    while (l < r) {
        var mid = (l + r) ushr 1
        var count = 1
        var sum = 0L
        for (num in nums) {
            sum += num
            if (sum > mid) {
                sum = num.toLong()
                count++
                if (count > m) {
                    break
                }
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