package countingbits

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var ret = n
    while (m < ret) {
        ret = ret and ret - 1
    }
    return ret
}

class _201_Solution_ {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var a = m
        var b = n
        var shift = 0
        while (a != b) {
            a = a shr 1
            b = b shr 1
            shift++
        }
        return a shl shift
    }
}