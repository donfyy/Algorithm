fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
    val dirs = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1), intArrayOf(0, -1),
            intArrayOf(0, 1), intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1))
    return board.apply {
        val (i, j) = click
        if (this[i][j] == 'M') {
            this[i][j] = 'X'
        } else {
            val m = this.size
            val n = this[0].size
            fun dfs(i: Int, j: Int) {
                var c = 0
                for (dir in dirs) {
                    val x = i + dir[0]
                    val y = j + dir[1]
                    if (x in 0 until m && y in 0 until n && this[x][y] == 'M') {
                        c++
                    }
                }
                if (c != 0) {
                    this[i][j] = '0' + c
                } else {
                    this[i][j] = 'B'
                    for (dir in dirs) {
                        val x = i + dir[0]
                        val y = j + dir[1]
                        if (x in 0 until m && y in 0 until n && this[x][y] == 'E') {
                            dfs(x, y)
                        }
                    }
                }
            }
            dfs(i, j)
        }
    }
}