fun reverseWords(s: CharArray): Unit {
    if (s.isEmpty()) return
    var i = 0; var j = 0; var length = s.size
    reverse(s, 0, length - 1)
    while (i < length) {
        while (j < length && s[j] != ' ') j++
        reverse(s, i, j - 1)
        i = ++j
    }
}
