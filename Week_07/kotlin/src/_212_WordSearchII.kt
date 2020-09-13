class Solution {
    // 时间 O(min(HK, MN*3^K)) 空间 O(HK) H:单词的数量 K:单词的平均长度
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = Trie().apply { words.forEach { insert(it) } }
        val ret = mutableListOf<String>()
        val path = StringBuilder()
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        fun dfs(i: Int, j: Int, node: Trie) {
            val c = board[i][j]
            val child = node.childAt(c)
            if (child == null) return
            path.append(c)
            if (child.isEnd) {
                ret += path.toString()
                child.isEnd = false
            }
            board[i][j] = '#'
            dirs.forEach { (di, dj) ->
                val u = i + di
                val v = j + dj
                if (u in board.indices && v in board[0].indices && board[u][v] != '#')
                    dfs(u, v, child)
            }
            path.setLength(path.lastIndex)
            board[i][j] = c
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(i, j, trie)
            }
        }
        return ret
    }

    class Trie {
        val children = Array<Trie?>(26) { null }
        var isEnd = false

        fun insert(word: String) {
            var node = this
            word.forEach {
                node = node.children[it - 'a']?:Trie().apply { node.children[it - 'a'] = this }
            }
            node.isEnd = true
        }

        fun childAt(c: Char) = children[c - 'a']
    }
}