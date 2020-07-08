import java.lang.StringBuilder

class _52_NQueensII_KT_Solution {
    var count = 0
    fun totalNQueens(n: Int): Int {
        if (n < 1) return 0
        dfs(0, 0, 0, 0, n)
        return count
    }
    fun dfs(row:Int, col:Int, pie:Int, na:Int, n:Int) {
        if (row == n) {
            count++
            return
        }

        var bits = (col or pie or na).inv() and ((1 shl n) - 1)
        while (bits > 0) {
            val pos = bits and (-bits)
            bits = bits and (bits - 1)
            dfs(row + 1, col or pos, (pie or pos) shl 1, (na or pos) shr 1, n)
        }
    }
}

fun main() {
    println(_52_NQueensII_KT_Solution().totalNQueens(4))
}