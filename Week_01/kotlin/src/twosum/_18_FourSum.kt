package twosum

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val n = nums.size
    val ret = arrayListOf<List<Int>>()
    nums.sort()
    for (i in 0..n - 4) {
        if (nums[i] > 0 && nums[i] > target) break
        if (i > 0 && nums[i] == nums[i - 1]) continue
        val t2 = target - nums[i]
        for (j in i + 1..n - 3) {
            if (nums[j] > 0 && nums[j] > t2) break
            if (j > i + 1 && nums[j] == nums[j - 1]) continue
            var l = j + 1
            var r = n - 1
            while (l < r) {
                val s = nums[j] + nums[l] + nums[r]
                when {
                    s == t2 -> {
                        ret.add(listOf(nums[i], nums[j], nums[l], nums[r]))
                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);
                    }
                    s > t2 -> r--
                    else -> l++
                }
            }
        }
    }
    return ret
}