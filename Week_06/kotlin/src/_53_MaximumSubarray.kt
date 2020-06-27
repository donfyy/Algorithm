fun maxSubArray(nums: IntArray): Int {
    //f(i)到第i个元素为止的连续子数组的最大和
    //f(i) = f(i - 1) > 0 ? f(i - 1) + value(i) : value(i)
    if (nums.isEmpty()) return 0
    var ret = nums[0]
    var dpi_1 = nums[0]
    for (i in 1 until nums.size) {
        val dpi = if(dpi_1 > 0) dpi_1 + nums[i] else nums[i]
        if (dpi > ret) ret = dpi
        dpi_1 = dpi
    }
    return ret
}