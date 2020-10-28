class _1207_ {
    class Solution {
        fun uniqueOccurrences(arr: IntArray): Boolean {
            val occur = hashMapOf<Int, Int>()
            arr.forEach { occur[it] = occur.getOrDefault(it, 0) + 1 }
            val unique = hashSetOf<Int>()
            occur.forEach {
                if (it.value in unique) return false
                unique += it.value
            }
            return true
        }
    }
}