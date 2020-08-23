package countingbits

fun rangeBitwiseAnd(m: Int, n: Int): Int {
    var ret = n
    while (m < ret) {
        ret = ret and ret - 1
    }
    return ret
}