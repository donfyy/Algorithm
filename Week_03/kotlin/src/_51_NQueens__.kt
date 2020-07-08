import java.util.*
//30m
class _51_NQueens__ {
    var queens: IntArray? = null
    var ret: LinkedList<List<String>>? = null
    fun solveNQueens(n: Int): List<List<String>> {
        if (n < 1) return Collections.emptyList()
        ret = LinkedList<List<String>>()
        queens = IntArray(n)
        dfs(0, n, 0, 0, 0)
        return ret!!
    }
    fun dfs(row:Int, n:Int, col:Int, pie:Int, na:Int) {
        if (row == n) {
            generateSolution()
            return
        }
        var bits = (col or pie or na).inv() and ((1 shl n) - 1)
        while (bits != 0) {
            val pos = bits and -bits
            queens!![row] = pos
            dfs(row + 1, n, col or pos, pie or pos shl 1, na or pos shr 1)
            bits = bits and bits - 1
        }
    }
    fun generateSolution() {
        var sb = StringBuilder()
        val list = LinkedList<String>()
        val n = queens!!.size
        for (i in 0 until n) {
            var row = queens!![i]
            for (col in 0 until n) {
                sb.append(if (row and 1 == 1) 'Q' else '.')
                row = row shr 1
            }    
            list.add(sb.toString())
            sb.delete(0, sb.length)
        }
        ret!!.add(list)
    }
}