//212ms
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val m = matrix.size
    val n = matrix[0].size
    var l = 0
    var h = m * n - 1;
    while (l <= h) {
        val mid = l + ((h - l) ushr 1)
        val v = matrix[mid / n][mid % n]
        if (v == target) {
            return true
        }
        if (target > v) {
            l = mid + 1
        } else {
            h = mid - 1
        }
    }
    return false
}

//268ms
fun searchMatrix1(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    val n = matrix[0].size
    var l = 0
    var h = matrix.size * n - 1;
    while (l < h) {
        val m = l + ((h - l) ushr 1)
        val v = matrix[m / n][m % n]
        if (target > v) l = m + 1 else h = m
    }
    return matrix[l / n][l % n] == target
}