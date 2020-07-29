import java.util.*

val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    val m = matrix.size
    val n = matrix[0].size
    var ret = 0
    val memo = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            ret = ret.coerceAtLeast(dfs(matrix, i, j, memo))
        }
    }
    return ret
}

fun dfs(matrix: Array<IntArray>, i: Int, j: Int, memo: Array<IntArray>): Int {
    if (memo[i][j] != 0) {
        return memo[i][j]
    }
    memo[i][j]++
    val m = matrix.size
    val n = matrix[0].size
    for (dir in dirs) {
        val i_ = i + dir[0]
        val j_ = j + dir[1]
        if (i_ in 0 until m && j_ in 0 until n && matrix[i_][j_] > matrix[i][j]) {
            memo[i][j] = memo[i][j].coerceAtLeast(dfs(matrix, i_, j_, memo) + 1)
        }
    }
    return memo[i][j]
}

fun longestIncreasingPathTopologicalSort(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return 0
    }
    val m = matrix.size
    val n = matrix[0].size
    val outDegrees = Array(m) { IntArray(n) }
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    for (i in 0 until m) {
        for (j in 0 until n) {
            for (dir in dirs) {
                val i_ = i + dir[0]
                val j_ = j + dir[1]
                if (i_ in 0 until m && j_ in 0 until n && matrix[i][j] < matrix[i_][j_]) {
                    outDegrees[i][j]++
                }
            }
        }
    }

    val queue = LinkedList<IntArray>()
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (outDegrees[i][j] == 0) {
                queue.offer(intArrayOf(i, j))
            }
        }
    }

    var level = 0
    while (!queue.isEmpty()) {
        var size = queue.size
        while (size-- > 0) {
            val (i, j) = queue.poll()
            for (dir in dirs) {
                val i_ = i + dir[0]
                val j_ = j + dir[1]
                if (i_ in 0 until m && j_ in 0 until n && matrix[i][j] > matrix[i_][j_]) {
                    outDegrees[i_][j_]--
                    if (outDegrees[i_][j_] == 0) {
                        queue.offer(intArrayOf(i_, j_))
                    }
                }
            }
        }
        level++
    }
    return level
}