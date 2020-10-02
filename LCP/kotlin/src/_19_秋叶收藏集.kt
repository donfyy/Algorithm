class _19_Dp {
    fun minimumOperations(leaves: String): Int {
        // f[i][j] 将[0, i]叶子调整完毕且第i片叶子处于状态j时的最少调整次数
        // f[i][0] = f[i - 1][0] + isYellow(i)
        // f[i][1] = min(f[i - 1][0], f[i - 1][1]) + isRed(i)
        // f[i][2] = min(f[i - 1][1], f[i - 1][2]) + isYellow(i);
        // f[0][0] = isYellow(0)
        // f[i][j] = n if i > j
        fun yellow(i: Int) = if (leaves[i] == 'y') 1 else 0
        fun red(i: Int) = if (leaves[i] == 'r') 1 else 0
        val n = leaves.length
        var f1 = yellow(0)
        var f2 = n
        var f3 = n
        for (i in 1 until n) {
            val g1 = f1 + yellow(i)
            val g2 = minOf(f1, f2) + red(i)
            val g3 = minOf(f2, f3) + yellow(i)
            f1 = g1
            f2 = g2
            f3 = g3
        }
        return f3
    }
}