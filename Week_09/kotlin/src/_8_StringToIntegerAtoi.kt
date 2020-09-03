class _8_ {
    fun myAtoi(s: String): Int {
        var ret = 0
        var sign = 0
        loop@ for (it in s.trim()) {
            when (it) {
                '+', '-' -> {
                    if (sign != 0) return ret * sign
                    sign = if (it == '+') 1 else -1
                }
                in '0'..'9' -> {
                    if (sign == 0) sign = 1
                    val num = it - '0'
                    if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                        return if (sign == 1) Integer.MAX_VALUE else Integer.MIN_VALUE
                    }
                    ret = ret * 10 + num
                }
                else -> break@loop
            }
        }
        return ret * sign
    }
}