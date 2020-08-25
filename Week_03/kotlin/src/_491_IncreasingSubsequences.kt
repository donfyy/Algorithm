fun findSubsequences(nums: IntArray): List<List<Int>> {
    val ret = mutableListOf<List<Int>>()
    val path = mutableListOf<Int>()
    val n = nums.size
    fun dfs(i: Int, last: Int) {
        if (i == n) {
            if (path.size > 1) {
                ret += path.toList()
            }
            return
        }
        if (nums[i] >= last) {
            path += nums[i]
            dfs(i + 1, nums[i])
            path.removeAt(path.lastIndex)
        }
        if (nums[i] != last) {
            dfs(i + 1, last)
        }
    }
    dfs(0, Integer.MIN_VALUE)
    return ret
}

class _491_DFS_2_ {
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        val ret = mutableSetOf<List<Int>>()
        val path = mutableListOf<Int>()
        val n = nums.size
        fun dfs(i: Int, last: Int) {
            if (path.size > 1) ret += path.toList()
            for (j in i until n) {
                if (nums[j] >= last) {
                    path += nums[j]
                    dfs(j + 1, nums[j])
                    path.removeAt(path.lastIndex)
                }
            }
        }
        dfs(0, Integer.MIN_VALUE)
        return ret.toList()
    }
}