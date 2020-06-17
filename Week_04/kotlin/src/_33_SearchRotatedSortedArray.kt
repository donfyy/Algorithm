fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    var l = 0
    var h = nums.size - 1
    while (l <= h) {
        val m = l + ((h - l) ushr 1)
        val v = nums[m]
        if (v == target) return m
        if (v >= nums[l]) {
            if (v > target && target >= nums[l]) h = m - 1 else l = m + 1
        } else {
            if (target >= nums[l] || target < v) h = m - 1 else l = m + 1
        }
    }
    return -1
}