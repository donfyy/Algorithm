class _77_纵 {
    // 时间 O(2^n * n) 空间 O(n)
    fun subsets(nums: IntArray): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()
        val n = nums.size
        fun dfs(i: Int) {
            if (i == n) {
                ret += path.toList()
                return
            }
            path += nums[i]
            dfs(i + 1)
            path.removeAt(path.lastIndex)
            dfs(i + 1)
        }
        dfs(0)
        return ret
    }
}