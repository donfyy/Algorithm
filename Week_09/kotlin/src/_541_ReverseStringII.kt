fun reverseStr(s: String, k: Int): String {
    val length = s.length
    val array = s.toCharArray()
    for (i in 0 until length step (k shl 1)) {
        reverse(array, i, Math.min(length - 1, i + k - 1))
    }
    return String(array)
}

fun reverse(array : CharArray,left: Int, right: Int) {
    var l = left
    var r = right
    while (l < r) {
        val temp = array[l]
        array[l] = array[r]
        array[r] = temp
        l++
        r--
    }
}