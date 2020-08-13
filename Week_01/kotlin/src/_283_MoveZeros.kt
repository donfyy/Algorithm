fun moveZeroes(nums: IntArray): Unit {
    var j = -1
    for (i in nums.indices) {
        if (nums[i] != 0 && ++j != i) {
            nums[j] = nums[i]
            nums[i] = 0
        }
    }
}