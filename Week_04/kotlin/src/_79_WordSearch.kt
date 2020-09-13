class _79_Dfs {
    // 时间 O(mn * 3^L) 空间 O(min(L, mn)) L表示word的长度
    fun exist(board: Array<CharArray>, word: String): Boolean {
        var idx = 0
        val n = word.length
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        fun dfs(i: Int, j: Int): Boolean {
            if (idx == n) return true
            if (i !in board.indices || j !in board[0].indices || board[i][j] == '#' || board[i][j] != word[idx]) return false
            val c = board[i][j]
            board[i][j] = '#'
            idx++
            var ret = false
            for ((di, dj) in dirs) {
                if (dfs(i + di, j + dj)) {
                    ret = true
                    break
                }
            }
            idx--
            board[i][j] = c
            return ret
        }
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (dfs(i, j)) return true
            }
        }
        return false
    }
}