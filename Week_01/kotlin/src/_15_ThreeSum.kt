fun main() {

    println(threeSum(intArrayOf(-1, 0, 1)))
}
fun threeSum(nums: IntArray): List<List<Int>> {
    if (nums.size < 3) return java.util.Collections.emptyList()
    java.util.Arrays.sort(nums)

    val ret = java.util.ArrayList<List<Int>>()
    for (i in 0..nums.size - 3) {
        if (nums[i] > 0) continue
        if (i > 0 && nums[i] == nums[i - 1]) continue
        var l = i + 1
        var r = nums.size - 1
        val curr = nums[i];
        while (l < r) {
            val sum = curr + nums[l] + nums[r]
            when {
                sum == 0 -> {
                    ret.add(listOf(curr, nums[l], nums[r]))

                    while (l < r && nums[l++] == nums[l])
                    while (l < r && nums[r--] == nums[r]);
                }
                sum > 0 -> {
                    r--
                }
                else -> {
                    l++
                }
            }
        }
    }
    return ret
}
