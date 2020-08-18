package graph

import java.util.*

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    val oldColor = image[sr][sc]
    if (oldColor == newColor) return image
    val m = image.size
    val n = image[0].size
    val queue = LinkedList<IntArray>()
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    queue.offer(intArrayOf(sr, sc))
    while (queue.isNotEmpty()) {
        val (i, j) = queue.poll()
        image[i][j] = newColor
        for (dir in dirs) {
            val x = i + dir[0]
            val y = j + dir[1]
            if (x in 0 until m && y in 0 until n && image[x][y] == oldColor) {
                queue.offer(intArrayOf(x, y))
            }
        }
    }
    return image
}

class _733_Dfs {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val oldColor = image[sr][sc]
        if (oldColor == newColor) return image
        val m = image.size
        val n = image[0].size
        val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        fun dfs(i: Int, j: Int) {
            if (i !in 0 until m || j !in 0 until n || image[i][j] != oldColor) {
                return
            }
            image[i][j] = newColor
            for (dir in dirs) {
                dfs(i + dir[0], j + dir[1])
            }
        }
        dfs(sr, sc)
        return image
    }
}