package twosum

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = HashMap<Int, Int>()
    for (i in nums.indices) {
        (target - nums[i])
            .takeIf { it in map }
            ?.let { return intArrayOf(map[it]!!, i) }
            ?: run { map[nums[i]] = i }
    }
    return intArrayOf(-1, -1)
}
class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        if (num.length < 3) return false
        for (i in 1 until num.length - 1) {
            if (num[i] == '0') continue
            if (recursive(0, i, -1.0, -1.0, num)) {
                return true
            }
        }
        return false
    }
    fun recursive(l: Int, r: Int, pre: Double, prepre:Double, num: String):Boolean {
        // fix 0 at r
        val cur = num.substring(l, r).toDouble()
        if (pre == -1.0 || prepre == -1.0) {
            for (rn in r + 1 .. num.length) {
                if (rn < num.length && num[rn] == '0') continue
                if (recursive(r, rn, cur, pre, num)) {
                    return true
                }
            }
        }
        if (pre + prepre == cur) {
            if (r == num.length) return true
            for (rn in r + 1 .. num.length) {
                if (rn < num.length && num[rn] == '0') continue
                if (recursive(r, rn, cur, pre, num)) {
                    return true
                }
            }
        }
        return false
    }
}

fun main() {
    println(Solution().isAdditiveNumber("1023"))
}
