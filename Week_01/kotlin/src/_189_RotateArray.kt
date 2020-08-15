fun rotate(nums: IntArray, k: Int): Unit {
    val n = nums.size
    val k_ = k % n
    reverse(nums, 0, n - 1)
    reverse(nums, 0, k_ - 1)
    reverse(nums, k_, n - 1)
}

fun reverse(nums: IntArray, left: Int, right: Int) {
    var l = left
    var r = right
    while (l < r) {
        nums[l] = nums[r].also { nums[r] = nums[l] }
        l++
        r--
    }
}

class SolutionReplace {
    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        val k_ = k % n
        var count = 0
        var start = 0
        while (count < n) {
            var curr = start
            var pre = nums[curr]
            do {
                val next = (curr + k_) % n
                nums[next] = pre.also { pre = nums[next] }
                count++
                curr = next
            } while (curr != start)
            start++
        }
    }
}