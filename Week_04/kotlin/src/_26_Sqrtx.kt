fun main() {
    println(mySqrt1(1))
}
fun mySqrt1(x: Int): Int {
    var r = x.toLong()
    while (r * r > x) r = ((r + x / r) ushr 1)
    return r.toInt()
}
//164ms
fun mySqrt2(x: Int): Int {
    if (x < 0) return -1;
    if (x == 0) return 0;
    if (x == 1) return 1;
    var l = 0
    var h = x
    while (l < h) {
        val m = l + ((h - l) ushr 1)
        val d = x / m
        if (d == m) return d
        if (d > m) l = m + 1 else h = m
    }
    return l - 1
}