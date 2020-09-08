class _347_UsingSequence {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val path = mutableListOf<Int>()
        val ret = mutableListOf<List<Int>>()
        fun dfs(i: Int) {
            if (path.size + n - i + 1 < k) return
            if (path.size == k) {
                ret += path.toList()
                return
            }
            path += i
            dfs(i + 1)
            path.removeAt(path.lastIndex)
            dfs(i + 1)
        }
        dfs(1)
        return ret
    }
}