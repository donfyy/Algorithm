fun findMagicIndex(nums: IntArray): Int {
    //b[i] = a[i] - i 不具有单调性，故无法使用二分法
    var i = 0
    var n = nums.size
    while (i < n) {
        if (nums[i] == i) {
            return i
        }
        if (i < nums[i]) {
            i = nums[i]
        } else {
            i++
        }
    }
    return -1
}