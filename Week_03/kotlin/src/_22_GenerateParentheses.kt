class _22_dfs {
    fun generateParenthesis(n: Int): List<String> {
        val ret = mutableListOf<String>()
        val path = StringBuilder()
        fun dfs(l: Int, r: Int) {
            if (l == 0 && r == 0) {
                ret += path.toString()
                return
            }
            if (l > 0) {
                path.append('(')
                dfs(l - 1, r)
                path.setLength(path.length - 1)
            }
            if (r > l) {
                path.append(')')
                dfs(l, r - 1)
                path.setLength(path.length - 1)
            }
        }
        dfs(n, n)
        return ret
    }
}