fun findCircleNum(M: Array<IntArray>): Int {
    val m = M.size
    val visited = BooleanArray(M.size){false}
    var count = 0;
    for (i in 0 until m) {
        if (!visited[i]) {
            dfs(M, i, visited)
            count++;
        }
    }
    return count;
}

fun dfs(M: Array<IntArray>, i: Int, visited: BooleanArray) {
    if (visited[i]) {
        return
    }
    visited[i] = true
    for (j in M.indices) {
        if (M[i][j] == 1) {
            dfs(M, j, visited)
        }
    }
}