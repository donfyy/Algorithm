class _51_1 {
    fun solveNQueens(n: Int): List<List<String>> {
        if (n < 1) return emptyList()
        val queen = IntArray(n)
        val mask = (1 shl n) - 1
        val ret = mutableListOf<List<String>>()
        fun generateSolution() {
            val sb = StringBuilder()
            val list = mutableListOf<String>()
            queen.forEach {
                var r = it
                repeat(n) {
                    sb.append(if ((r and 1) == 1) 'Q' else '.')
                    r = r ushr 1
                }
                list += sb.toString()
                sb.delete(0, sb.length)
            }
            ret += list
        }
        fun dfs(i: Int, pie: Int, na: Int, col: Int) {
            if (i == n) {
                generateSolution()
                return
            }
            var pos = (pie or na or col).inv() and mask
            while (pos != 0) {
                val p = pos and -pos
                queen[i] = p
                dfs(i + 1, pie or p shl 1, na or p ushr 1, col or p)
                pos = pos and pos - 1
            }
        }
        dfs(0, 0, 0, 0)
        return ret
    }
}

class _51_2 {
    fun solveNQueens(n: Int): List<List<String>> {
        if (n < 1) return emptyList()
        val queens = IntArray(n)
        val col = BooleanArray(n)
        val pie = BooleanArray((n shl 1) - 1)
        val na = BooleanArray((n shl 1) - 1)
        val ret = mutableListOf<List<String>>()

        fun dfs(i: Int) {
            if (i == n) {
                val sb = StringBuilder()
                val list = mutableListOf<String>()
                queens.forEach { j ->
                    repeat(n) { sb.append(if (it == j) 'Q' else '.') }
                    list += sb.toString()
                    sb.delete(0, sb.length)
                }
                ret += list
                return
            }
            repeat(n) { j ->
                if (!col[j] && !pie[i + j] && !na[i - j + n - 1]) {
                    queens[i] = j
                    col[j] = true
                    pie[i + j] = true
                    na[i - j + n - 1] = true
                    dfs(i + 1)
                    col[j] = false
                    pie[i + j] = false
                    na[i - j + n - 1] = false
                }
            }
        }
        dfs(0)
        return ret
    }
}