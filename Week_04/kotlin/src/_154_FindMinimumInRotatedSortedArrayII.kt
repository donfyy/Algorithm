class _154_BinarySearch_1 {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val m = (l + r) ushr 1
            when {
                nums[m] > nums[r] -> {
                    l = m + 1
                }
                nums[m] < nums[r] -> {
                    r = m
                }
                else -> {
                    r--
                }
            }
        }
        return nums[l]
    }
}