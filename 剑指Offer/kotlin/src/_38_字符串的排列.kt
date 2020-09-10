class _38_1 {
    fun permutation(s: String): Array<String> {
        val arr = s.toCharArray()
        val n = arr.size
        val ret = mutableListOf<String>()
        fun dfs(start: Int) {
            if (start == n - 1) {
                ret += String(arr)
                return
            }
            val table = mutableSetOf<Char>()
            for (i in start until n) {
                if (arr[i] in table) continue
                table += arr[i]
                arr[start] = arr[i].also { arr[i] = arr[start] }
                dfs(start + 1)
                arr[start] = arr[i].also { arr[i] = arr[start] }
            }
        }
        dfs(0)
        return ret.toTypedArray()
    }
}