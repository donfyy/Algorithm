fun maxProduct(nums: IntArray): Int {
    //f(i)以第i个元素为结尾的连续子数组的最大乘积
    //h(i)以第i个元素为结尾的连续子数组的最小乘积
    //有可能负负得正
    //f(i) = max(value(i), value(i) * f(i), value(i) * h(i))
    if (nums.isEmpty()) return 0
    var ret = nums[0]
    var dpMax = ret
    var dpMin = ret
    for (i in 1 until nums.size) {
        val v1 = nums[i]
        val v2 = v1 * dpMax
        val v3 = v1 * dpMin
        dpMax = Math.max(v1, Math.max(v2, v3))
        dpMin = Math.min(v1, Math.min(v2, v3))
        ret = Math.max(ret, dpMax)
    }
    return ret
}