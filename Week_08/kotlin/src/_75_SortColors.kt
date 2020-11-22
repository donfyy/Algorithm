class _75_SortColors_ {
    class Solution {
        fun sortColors(nums: IntArray): Unit {
            // 比较排序的最佳时间复杂度就是O(nlogn)不可能是常数时间复杂度
            // 题目提示使用常数空间，也就是要使用非比较排序，也就是要使用计数排序
            val bucket = IntArray(3)
            nums.forEach { bucket[it]++ }
            var i = 0
            bucket.forEachIndexed { idx, v ->
                repeat(v) { nums[i++] = idx }
            }
        }
    }
}