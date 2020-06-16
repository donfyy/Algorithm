fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    if (strs.size == 1) return strs[0]
    val first = strs[0]
    var i = -1
    out@ while (++i < first.length) {
        val c = first[i]
        for (j in 1 until strs.size) {
            val str = strs[j]
            if (str.length == i || str[i] != c) break@out
        }
    }
    return first.subSequence(0, endIndex = i).toString()
}
