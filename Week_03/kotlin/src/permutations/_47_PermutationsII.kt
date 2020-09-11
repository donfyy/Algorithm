package permutations

class _47_UsingSwap {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val n = nums.size - 1
        fun dfs(start: Int) {
            if (start == n) {
                ret += nums.toList()
                return
            }
            val table = HashSet<Int>();
            /*loop@*/ for (i in start..n) {
                if (nums[i] in table) continue
                table += nums[i];
                // for (j in start until i) {
                //     if (nums[i] == nums[j]) continue@loop
                // }
                nums[i] = nums[start].also { nums[start] = nums[i] }
                dfs(start + 1);
                nums[i] = nums[start].also { nums[start] = nums[i] }
            }
        }
        dfs(0)
        return ret
    }
}