class _126_UsingBiBfs {
    fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {
        val ret = mutableListOf<List<String>>()
        val wordSet = wordList.toMutableSet()
        if (endWord !in wordSet) return ret
        val edges = HashMap<String, MutableSet<String>>()
        fun biBfs(): Boolean {
            var beginSet = mutableSetOf(beginWord)
            var endSet = mutableSetOf(endWord)
            wordSet.apply {
                remove(beginWord)
                remove(endWord)
            }
            var forward = true
            while (beginSet.isNotEmpty()) {
                var find = false
                val nextSet = mutableSetOf<String>()
                val nextVisited = mutableSetOf<String>()
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
                                    edges.computeIfAbsent(p) { mutableSetOf() }.add(v)
                                }
                                in wordSet -> {
                                    nextSet += v
                                    nextVisited += v
                                    var p = u
                                    if (!forward) p = v.also { v = p }
                                    edges.computeIfAbsent(p) { mutableSetOf() }.add(v)
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
        val path = mutableListOf(beginWord)
        fun dfs(u: String) {
            if (u == endWord) {
                ret += path.toList()
                return
            }
            edges[u]?.forEach { v ->
                path += v
                dfs(v)
                path.removeAt(path.lastIndex)
            }
        }
        dfs(beginWord)
        return ret
    }
}