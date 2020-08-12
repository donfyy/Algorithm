fun solve(board: Array<CharArray>): Unit {
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    fun dfs(board: Array<CharArray>, i: Int, j: Int) {
        if (i !in board.indices || j !in board[0].indices || board[i][j] == 'X' || board[i][j] == '#') {
            return
        }

        board[i][j] = '#'
        for (dir in dirs) {
            dfs(board, i + dir[0], j + dir[1])
        }
    }

    val m = board.size.takeIf { it >= 3 } ?: return
    val n = board[0].size.takeIf { it >= 3 } ?: return

    for (i in intArrayOf(0, m - 1)) {
        for (j in 0 until n) {
            if (board[i][j] == 'O') {
                dfs(board, i, j)
            }
        }
    }

    for (j in intArrayOf(0, n - 1)) {
        for (i in 1..m - 2) {
            if (board[i][j] == 'O') {
                dfs(board, i, j)
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            when (board[i][j]) {
                'O' -> {
                    board[i][j] = 'X'
                }
                '#' -> {
                    board[i][j] = 'O'
                }
            }
        }
    }
}