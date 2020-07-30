fun rob(nums: IntArray): Int {
    //f(i)偷到i为止可以偷到的最大金额
    //f(i)表示从0到第i间房子能够偷窃到的最高金额
    //如果偷窃第i间房子,f(i) = nums[i] + f(i - 1) = nums[i] + f(i - 2)
    //如果不偷窃第i间房子,f(i) = f(i - 1)
    //f(i) = max(f(i - 1), nums[i] + f(i - 2))
    //f(0) = nums[0] f(1) = max(nums[0], nums[1])
    if (nums.isEmpty()) {
        return 0
    }

    var leftPreceding = 0
    var left = 0
    for (num in nums) {
        val dp = left.coerceAtLeast(num + leftPreceding)
        leftPreceding = left
        left = dp
    }
    return left
}

fun rob2(nums: IntArray): Int {
    //f(i)表示从0到第i间房子能够偷窃到的最高金额
    //f(i)[0] 不偷第i间房子可以得到的最大金额 f(i)[1] 表示偷第i间房子可以得到的最大金额
    //f(i)[0] = max(f(i - 1)[0], f(i - 1)[1])
    //f(i)[1] = f(i - 1)[0] + nums[i]
    //f(0)[0] = 0, f(0)[1] = nums[0]
    if (nums.isEmpty()) {
        return 0
    }
    var leftNotRob = 0
    var leftRob = nums[0]
    for (i in 1 until nums.size) {
        val notRob = leftRob.coerceAtLeast(leftNotRob)
        leftRob = leftNotRob + nums[i]
        leftNotRob = notRob
    }
    return leftRob.coerceAtLeast(leftNotRob)
}