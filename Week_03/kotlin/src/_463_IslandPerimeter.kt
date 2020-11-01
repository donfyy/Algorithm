class _463_IslandPerimeter_ {
    class Solution {
        fun islandPerimeter(grid: Array<IntArray>): Int {
            // 统计每块陆地与水域或边界相邻的边
            // 要计算岛屿的周长
            // 计算每个陆地对周长的贡献
            // 对于每个陆地的边，如果这条边与水域相连或者是边界，那么这条边就对周长有贡献
            val m = grid.size
            val n = grid[0].size
            var ret = 0
            val dirs = arrayOf(intArrayOf(0, -1), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(1, 0))
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (grid[i][j] == 0) {
                        continue
                    }
                    for ((di, dj) in dirs) {
                        val x = i + di
                        val y = j + dj
                        if (x !in 0 until m || y !in 0 until n || grid[x][y] == 0) {
                            ret++
                        }
                    }
                }
            }
            return ret
        }
    }
}