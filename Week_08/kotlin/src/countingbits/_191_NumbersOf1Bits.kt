package countingbits

// you need treat n as an unsigned value
fun hammingWeight(n:Int):Int {
    var count = 0
    var m = n
    while (m != 0) {
        count++
        m = m and m - 1
    }
    return count
}
