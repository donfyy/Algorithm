class _45_UsingReverseGreedy {
    // O(n^2) O(1)
    fun jump(nums: IntArray): Int {
        var pos = nums.size - 1
        var step = 0
        while (pos > 0) {
            val oldPos = pos
            for (i in 0 until pos) {
                if (i + nums[i] >= pos) {
                    pos = i
                    step++
                    break
                }
            }
            if (oldPos == pos) return -1
        }
        return step
    }
}