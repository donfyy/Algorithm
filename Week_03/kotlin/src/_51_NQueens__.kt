import java.util.*

//30m
class _51_NQueens__ {
    var queens = IntArray(0)
    var mask = 0
    var ret = LinkedList<List<String>>()
    fun solveNQueens(n: Int): List<List<String>> {
        if (n < 1) return Collections.emptyList();

        mask = (1 shl n) - 1
        queens = IntArray(n)
        dfs(0, n, 0, 0, 0)
        return ret;
    }

    fun dfs(row: Int, n: Int, col: Int, pie: Int, na: Int) {
        if (row == n) {
            generateSolution(n)
            return
        }
        var bits = (col or pie or na).inv() and mask
        while (bits != 0) {
            val pos = bits and -bits
            queens[row] = pos
            dfs(row + 1, n, col or pos, pie or pos shl 1, na or pos shr 1)
            bits = bits and bits - 1
        }
    }

    fun generateSolution(n: Int) {
        val sb = StringBuilder()
        val row = LinkedList<String>()
        for (pos in queens) {
            var m = n;
            var p = pos;
            while (m > 0) {
                sb.append(if ((p and 1) == 1) 'Q' else '.')
                p = p shr 1
                m--
            }
            row.add(sb.toString())
            sb.delete(0, sb.length)
        }
        ret.add(row)
    }
}