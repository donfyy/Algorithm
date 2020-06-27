fun maxSubArray(nums: IntArray): Int {
    //f(i) 以第i个元素为结尾的连续子数组的最大和
    //f(i) = max(f(i - 1), 0) + value(i)
    if (nums.isEmpty()) return 0
    var ret = nums[0]
    var dp = nums[0]
    for (i in 1..nums.size - 1) {
        dp = Math.max(dp, 0) + nums[i]
        ret = Math.max(ret, dp)
    }
    return ret
}