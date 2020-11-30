fun main() {
    println(_164_MaximumGap_.Solution().maximumGap(intArrayOf(3, 6, 9, 1)))
}
class _164_MaximumGap_ {
    class Solution {
        fun maximumGap(nums: IntArray): Int {
            // 相邻元素之间的最大间距不小于(max - min) / (n - 1)
            // 反证法：假设相邻元素之间的间距都小于(max - min) / (n - 1)
            // 排序后的元素序列为 A0...An-1
            // An-1 - A0 = (An-1 - An-2) + (An-2 - An-3) + ... + (A1 - A0)
            // < (max - min) / n - 1 ... < max - min 矛盾
            // 令 bucketSize = floor((max - min) / (n - 1))
            // 则桶内元素的最大间距为bucketSize - 1，因此具有最大间距的元素一定在不同桶内
            val n = nums.size
            if (n < 2) return 0
            val max = nums.max()!!
            val min = nums.min()!!
            val bucketSize = maxOf(1, (max - min) / (n - 1))
            val bucketCount = (max - min) / bucketSize + 1
            val bucket = Array(bucketCount) { intArrayOf(-1, -1) }
            nums.forEach {
                val p = bucket[(it - min) / bucketSize]
                if (p[0] == -1) {
                    p[0] = it
                    p[1] = it
                } else {
                    p[0] = minOf(p[0], it)
                    p[1] = maxOf(p[1], it)
                }
            }
            var ret = 0
            var prev = -1
            bucket.forEachIndexed { idx, v ->
                if (v[0] == -1) return@forEachIndexed
                if (prev != -1) {
                    ret = maxOf(ret, v[0] - bucket[prev][1])
                }
                prev = idx
            }
            return ret
        }
    }
}