fun canJump(nums: IntArray): Boolean {
    var k = 0;
    for (i in nums.indices) {
        if(i > k) return false;
        k = Math.max(k, i + nums[i])
    }
    return true
}