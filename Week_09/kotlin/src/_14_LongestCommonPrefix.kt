fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    val firstRow = strs[0];
    var i = -1
    out@ while (++i < firstRow.length) {
        val c = firstRow[i]
        for (j in 1 until strs.size) {
            val s = strs[j];
            if (s.length == i || s[i] != c) break@out
        }
    }
    return firstRow.substring(0, i)
}
