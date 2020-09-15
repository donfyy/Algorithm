class _50_UsingMath {
    // 时间 O(logn) 空间 O(1)
    fun myPow(x: Double, n: Int): Double {
        var m = if (n < 0) -n.toLong() else n.toLong()
        var y = x
        var ret = 1.0
        while (m != 0L) {
            if (m and 1 == 1L) {
                ret *= y
            }
            y *= y
            m = m ushr 1
        }
        return if (n < 0) 1 / ret else ret
    }
}