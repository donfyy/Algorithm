fun climbStairs(n: Int): Int {
    //f(i) = f(i - 1) + f(i - 2)
    var p = 0
    var q = 0
    var r = 1
    repeat(n) {
        p = q
        q = r
        r = p + q
    }
    return r
}