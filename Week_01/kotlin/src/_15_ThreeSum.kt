fun threeSum(nums: IntArray): List<List<Int>> {
    val n = nums.size
    val ret = arrayListOf<List<Int>>()
    nums.sort()
    for (i in 0..n - 3) {
        if (nums[i] > 0) break
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var l = i + 1
        var r = n - 1
        while (l < r) {
            val sum = nums[i] + nums[l] + nums[r]
            when {
                sum == 0 -> {
                    ret.add(listOf(nums[i], nums[l], nums[r]))
                    while (l < r && nums[l] == nums[++l]);
                    while (l < r && nums[r] == nums[--r]);
                }
                sum < 0 -> {
                    l++
                }
                else -> {
                    r--
                }
            }
        }
    }
    return ret
}