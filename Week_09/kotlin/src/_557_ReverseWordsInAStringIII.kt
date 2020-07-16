fun reverseWords(s: String): String {
    val array = s.toCharArray()
    var i = 0; var j = 0; var length = array.size
    while (i < length) {
        while (j < length && array[j] != ' ') j++
        reverse(array, i, j - 1)
        i = ++j
    }
    return String(array)
}
