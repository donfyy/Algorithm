class _53_ {
    class Solution {
        fun maxSubArray(nums: IntArray): Int {
            // f(i) 以i为结尾的连续子数组的最大和
            // f(i) = max(f(i - 1), 0) + value(i)
            // f(0) = 0
            var f = Integer.MIN_VALUE
            var ret = f
            for (v in nums) {
                f = maxOf(f, 0) + v
                ret = maxOf(ret, f)
            }
            return ret
        }
    }
}
