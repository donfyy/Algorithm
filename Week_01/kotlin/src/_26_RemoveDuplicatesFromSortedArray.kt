fun removeDuplicates(nums: IntArray): Int {
    var j = 0
    for (i in 1 until nums.size) {
        if (nums[i] != nums[j]) {
            nums[++j] = nums[i]
        }
    }
    return j + 1
}

fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2)))
    //test ushr
    println(Int.MAX_VALUE.toString() + "\n:" + Integer.toBinaryString(Int.MAX_VALUE))
    println("""
    ${Int.MAX_VALUE + Int.MAX_VALUE}
    :${Integer.toBinaryString(Int.MAX_VALUE + 1)}
    :${java.lang.Long.toBinaryString(Int.MAX_VALUE.toLong() + 1L)}
    """.trimIndent())
    println(Int.MAX_VALUE + 1 ushr 1)
    println(Int.MAX_VALUE + 1 shr 1)
}
