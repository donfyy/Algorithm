package twosum

class _560_ {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val t = HashMap<Int,Int>()
        var ret = 0; var sum = 0
        nums.forEach {
            sum += it
            if (sum - k in t) ret += t[sum - k]!!
            if (sum in t) t[sum] = t[sum]!! + 1 else t[sum] = 1
        }
        return ret
    }
}