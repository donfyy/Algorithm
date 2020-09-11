package combinations

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

class _77_奇技淫巧 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val ret = mutableListOf<List<Int>>()
        val path = IntArray(k)
        var i = 0
        while (i >= 0) {
            path[i]++
            when {
                path[i] > n -> i--
                i == k - 1 -> ret += path.toList()
                else -> {
                    i++
                    path[i] = path[i - 1]
                }
            }
        }
        return ret
    }
}