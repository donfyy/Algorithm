fun rob(nums: IntArray): Int {
    //f(i)偷到i为止可以偷到的最大金额
    //f(i) = max(f(i-1), f(i-2) + nums[i])
    if (nums.isEmpty()) return 0
    var dpi_1 = nums[0]
    var dpi_2 = 0
    for (i in 1 until nums.size) {
        var dp = Math.max(dpi_1, dpi_2 + nums[i])
        dpi_2 = dpi_1
        dpi_1 = dp
    }
    return dpi_1
}

fun rob2(nums: IntArray): Int {
    //f(i)(0)i不偷可以偷到的最大金额
    //f(i)(1)i偷可以偷到的最大金额
    //f(i)(0) = max(f(i - 1)(0), f(i - 1)(1))
    //f(i)(1) = f(i - 1)(0) + nums[i]
    if (nums.isEmpty()) return 0
    var dpi_1_0 = 0
    var dpi_1_1 = nums[0]

    for (i in 1 until nums.size) {
        val dpi_0 = Math.max(dpi_1_0, dpi_1_1)
        val dpi_1 = dpi_1_0 + nums[i]

        dpi_1_0 = dpi_0
        dpi_1_1 = dpi_1
    }

    return Math.max(dpi_1_0, dpi_1_1)
}