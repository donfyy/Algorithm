fun shortestPalindrome(s: String): String {
    val t = StringBuilder(s).reverse()
    for (i in s.indices) {
        if (s.startsWith(t.substring(i))) {
            return t.substring(0, i) + s
        }
    }
    return ""
}