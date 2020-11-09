// 2020.11.09
class _327_CountOfRangeSum_ {
    class Solution {
        fun countRangeSum(nums: IntArray, lower: Int, upper: Int): Int {
            // 由区间和直接想到前缀和之差，要形成肌肉记忆
            val n = nums.size
            val cache = LongArray(n + 1)
            val pre = LongArray(n + 1)
            repeat(n) { pre[it + 1] = pre[it] + nums[it]}
            fun merge(left: Int, right: Int): Int {
                if (left >= right) return 0
                val mid = (left + right) ushr 1
                var ret = merge(left, mid)
                ret += merge(mid + 1, right)
                var l = mid + 1
                var r = l
                for (i in left..mid) {
                    while (l <= right && pre[l] < pre[i] + lower) l++
                    while (r <= right && pre[r] <= pre[i] + upper) r++
                    ret += r - l
                }
                l = left
                r = mid + 1
                var k = left
                while (l <= mid) {
                    while (r <= right && pre[r] < pre[l]) cache[k++] = pre[r++]
                    cache[k++] = pre[l++]
                }
                while (r <= right) {
                    cache[k++] = pre[r++]
                }
                System.arraycopy(cache, left, pre, left, right - left + 1)
                return ret
            }

            return merge(0, pre.lastIndex)
        }
    }
}