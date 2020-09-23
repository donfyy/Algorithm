class _200_Dfs {
    // O(MN) O(MN)
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val m = grid.size
        val n = grid[0].size
        val vis = Array(m) { BooleanArray(n) }
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        fun dfs(i: Int, j: Int): Boolean {
            if (vis[i][j] || grid[i][j] != '1') return false
            vis[i][j] = true
            for ((di, dj) in dirs) {
                val u = i + di
                val v = j + dj
                if (u in 0 until m && v in 0 until n) {
                    dfs(u, v)
                }
            }
            return true
        }
        var ret = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (dfs(i, j)) ret++
            }
        }
        return ret
    }
}