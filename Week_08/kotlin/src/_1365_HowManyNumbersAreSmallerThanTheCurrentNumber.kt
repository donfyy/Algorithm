class _1365_HowManyNumbersAreSmallerThanTheCurrentNumber_ {
    class Solution {
        // O(N + K)  O(K)
        fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val bucket = IntArray(101)
            val n = nums.size
            // 把数放到桶中
            // bucket[i] 表示 i 出现的次数
            nums.forEach { bucket[it]++ }
            // 计算比当前数小的数的数目
            // bucket[i] 表示 [0, i] 所有数出现的次数和
            for (i in 1..100) {
                bucket[i] += bucket[i - 1]
            }
            // 将数目放到数组中
            val ret = IntArray(n)
            repeat(n) {
                ret[it] = if (nums[it] == 0) 0 else bucket[nums[it] - 1]
            }
            return ret
        }
    }
}