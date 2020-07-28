fun splitArray(nums: IntArray, m: Int): Int {
    //f(i,j)表示将前i个数分割成m个连续子数组所能得到的最小的最大和。
    //f(i,j) = min(max(f(k, j - 1), sum(k, i))) k in (j - 1, i)
    //f(1, 1) = min(max(f(0, 0) = 0, sum(1, 1)))
    //f(2, 1) = min(max(f(1, 0) = MAX_VALUE, sum(2, 2)))
    //f(2, 1) = min(max(f(0, 0), sum(1, 2)))
    //i < j 时f(i, j)无意义
    //f(i, j) = Integer.MAX_VALUE f(0, 0) = 0
    if (nums.isEmpty() || nums.size < m) {
        return 0
    }
    val n = nums.size
    val dp = Array(n + 1) { LongArray(m + 1) { Long.MAX_VALUE } }
    dp[0][0] = 0
    val sum = LongArray(n + 1)
    for (i in 1..n) {
        sum[i] = sum[i - 1] + nums[i - 1]
    }
    for (i in 1..n) {
        for (j in 1..Math.min(i, m)) {
            for (k in 0..i) {
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i] - sum[k]))
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