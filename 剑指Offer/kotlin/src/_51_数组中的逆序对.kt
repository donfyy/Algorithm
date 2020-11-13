class _51_数组中的逆序对_ {
    class Solution {
        fun reversePairs(nums: IntArray): Int {
            val n = nums.size
            val cache = IntArray(n)
            fun merge(left: Int, right: Int): Int {
                if (left >= right) return 0
                val mid = (left + right) ushr 1
                var ret = merge(left, mid)
                ret += merge(mid + 1, right)

                var i = mid
                var j = right
                var k = right
                while (i >= left) {
                    while (j > mid && nums[i] <= nums[j]) {
                        cache[k--] = nums[j--]
                    }
                    ret += j - mid
                    cache[k--] = nums[i--]
                }
                while (j > mid) {
                    cache[k--] = nums[j--]
                }
                cache.copyInto(nums, left, left, right + 1)
                return ret
            }
            return merge(0, n -1)
        }
    }
}