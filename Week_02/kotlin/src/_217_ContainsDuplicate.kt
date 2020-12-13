class _217_ContainsDuplicate_ {
    class UsingSet {
        fun containsDuplicate(nums: IntArray): Boolean {
            // O(n) O(n)
            val s = HashSet<Int>()
            nums.forEach {
                if (it in s) return true
                s += it
            }
            return false
        }
    }

    class UsingSort {
        fun containsDuplicate(nums: IntArray): Boolean {
            // O(nlogn)
            nums.sort()
            repeat(nums.lastIndex) {
                if (nums[it] == nums[it + 1]) return true
            }
            return false
        }
    }
}