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