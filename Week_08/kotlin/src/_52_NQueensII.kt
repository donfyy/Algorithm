import java.lang.StringBuilder

class _52_NQueensII_KT_Solution {
    var ret = 0
    var mask = 0
    fun totalNQueens(n: Int): Int {
        if (n < 1) return 0
        mask = (1 shl n) - 1
        dfs(n, 0, 0, 0)
        return ret
    }

    fun dfs(row: Int, col: Int, pie: Int, na: Int) {
        if (row == 0) {
            ret++
            return
        }
        var bits = (col or pie or na).inv() and mask
        while (bits != 0) {
            val pos = bits and -bits
            dfs(row - 1, col or pos, pie or pos shl 1, na or pos shr 1)
            bits = bits and bits - 1
        }
    }
}

fun main() {
    println(_52_NQueensII_KT_Solution().totalNQueens(4))
}