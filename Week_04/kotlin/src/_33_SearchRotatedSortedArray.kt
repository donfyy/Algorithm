class _33_ {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l <= r) {
            val m = (l + r) ushr 1
            if (nums[m] == target) return m
            if (nums[m] >= nums[l]) {
                if (target < nums[m] && target >= nums[l]) r = m - 1 else l = m + 1
            } else {// [l, r] 一定是旋转数组
                if (target > nums[m] && target <= nums[r]) l = m + 1 else r = m - 1
            }
        }
        return -1
    }
}