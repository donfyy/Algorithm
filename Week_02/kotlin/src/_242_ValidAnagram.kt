fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val table = IntArray(26)
    for (i in s.indices) {
        table[s[i] - 'a']++
        table[t[i] - 'a']--
    }

    for (value in table) {
        if (value != 0) return false
    }
    return true
}