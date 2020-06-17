fun isPerfectSquare(num: Int): Boolean {
    if (num < 1) return false
    if (num == 1) return true
    var l = 1
    var h = num
    while (l < h) {
        val m = l + ((h - l) ushr 1)
        val r = 1L * m * m
        if (r == num.toLong()) return true
        if (r < num) l = m + 1 else h = m
    }
    return false
}

fun isPerfectSquare1(num: Int): Boolean {
    if (num < 1) return false
    var r = num.toLong()
    while (r * r > num) r = (r + num / r) ushr 1
    return r * r == num.toLong()
}

fun main() {
    println("a")
}