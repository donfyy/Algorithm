class _37_Dfs {
    // 第一次直接写出来困难题目的解法，加油
    // 时间 O(9*9*9) 空间 O(9*9)
    fun solveSudoku(board: Array<CharArray>): Unit {
        val n = board.size
        val total = n * n
        fun valid(i: Int, j: Int, k: Char): Boolean {
            for (c in board[i]) if (c == k) return false
            for (idx in 0 until n) if (board[idx][j] == k) return false
            val u = i / 3 * 3
            val v = j / 3 * 3
            for (idx in 0 until n) if (board[u + idx / 3][v + idx % 3] == k) return false
            return true
        }
        fun dfs(cur: Int) :Boolean{
            if (cur == total) return true
            val i = cur / n
            val j = cur % n
            if (board[i][j] != '.') {
                if (dfs(cur + 1)) return true
            } else {
                for (k in 1..n) {
                    if (valid(i, j, '0' + k)) {
                        board[i][j] = '0' + k
                        if (dfs(cur + 1)) return true
                        board[i][j] = '.'
                    }
                }
            }
            return false
        }
        dfs(0)
    }
}