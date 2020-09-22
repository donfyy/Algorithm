class _126_UsingBiBfs {
    // L 单词的平均长度  N 字典中单词的个数
    // O(V + E) O(V + E)  V = N, E  = N * 26 * L
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val ret = arrayListOf<List<String>>()
        // O(N)
        val wordSet = wordList.toHashSet()
        if (endWord !in wordSet) return ret
        val adjacency = hashMapOf<String, HashSet<String>>()
        fun biBfs(): Boolean {
            var beginSet = hashSetOf(beginWord)
            var endSet = hashSetOf(endWord)
            wordSet.apply {
                remove(beginWord)
                remove(endWord)
            }
            var forward = true
            while (beginSet.isNotEmpty()) {
                var find = false
                val nextSet = hashSetOf<String>()
                val nextVisited = hashSetOf<String>()
                for (u in beginSet) {
                    val arr = u.toCharArray()
                    for (i in arr.indices) {
                        val old = arr[i]
                        for (c in 'a'..'z') {
                            var v = String(arr.apply { arr[i] = c })
                            when (v) {
                                in endSet -> {
                                    find = true
                                    var p = u
                                    if (!forward) p = v.also { v = p }
                                    adjacency.computeIfAbsent(p) { hashSetOf() }.add(v)
                                }
                                in wordSet -> {
                                    nextSet += v
                                    nextVisited += v
                                    var p = u
                                    if (!forward) p = v.also { v = p }
                                    adjacency.computeIfAbsent(p) { hashSetOf() }.add(v)
                                }
                            }
                        }
                        arr[i] = old
                    }
                }
                if (find) return true
                if (nextSet.size > endSet.size) {
                    beginSet = endSet
                    endSet = nextSet
                    forward = !forward
                } else {
                    beginSet = nextSet
                }
                wordSet.removeAll(nextVisited)
            }
            return false
        }
        if (!biBfs()) return ret
        val path = arrayListOf(beginWord)
        fun dfs(u: String) {
            if (u == endWord) {
                ret += path.toList()
                return
            }
            adjacency[u]?.forEach { v ->
                path += v
                dfs(v)
                path.removeAt(path.lastIndex)
            }
        }
        dfs(beginWord)
        return ret
    }
}