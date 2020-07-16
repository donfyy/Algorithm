fun reverseString(s: CharArray): Unit {
    if (s.isEmpty()) return
    var l = 0; var r = s.size - 1
    while (l < r) {
        val temp = s[l]; s[l] = s[r]; s[r] = temp; l++; r--
    }
}