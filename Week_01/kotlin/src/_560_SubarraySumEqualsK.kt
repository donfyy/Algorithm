class _560_SubarraySumEqualsK_ {
    class Solution {
        // O(n) O(n)
        fun subarraySum(nums: IntArray, k: Int): Int {
            val freq = hashMapOf<Int, Int>().apply { this[0] = 1 }
            var sum = 0
            var ret = 0
            nums.forEach {
                sum += it
                ret += freq.getOrDefault(sum - k, 0)
                freq[sum] = freq.getOrDefault(sum, 0) + 1
            }
            return ret
        }
    }
}