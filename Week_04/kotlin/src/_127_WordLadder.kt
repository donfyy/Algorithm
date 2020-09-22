class UsingBiBfs {
    // L 表示单词的长度  N 表示字典中单词的个数
    // O(N + N * 26 * L)  O(N)
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toHashSet()
        if (endWord !in wordSet) return 0
        var beginSet = hashSetOf(beginWord)
        var endSet = hashSetOf(endWord)
        wordSet.apply {
            remove(beginWord)
            remove(endWord)
        }
        var ret = 2
        while (beginSet.isNotEmpty()) {
            val nextSet = hashSetOf<String>()
            for (u in beginSet) {
                val arr = u.toCharArray()
                for (i in arr.indices) {
                    val old = arr[i]
                    for (c in 'a'..'z') {
                        arr[i] = c
                        val v = String(arr)
                        if (v in endSet) return ret
                        if (v in wordSet) {
                            nextSet += v
                            wordSet.remove(v)
                        }
                    }
                    arr[i] = old
                }
            }
            ret++
            if (nextSet.size < endSet.size) {
                beginSet = endSet
                endSet = nextSet
            } else {
                beginSet = nextSet
            }
        }
        return 0
    }
}