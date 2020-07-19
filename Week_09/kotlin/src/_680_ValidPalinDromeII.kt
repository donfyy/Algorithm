fun validPalindrome(s: String): Boolean {
    if (s.isEmpty()) return false;
    return recursion(s, 0, s.length - 1, false);
}

fun recursion(s: String, left: Int, right: Int, deleted: Boolean): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l] != s[r]) {
            if (deleted) return false
            return recursion(s, l + 1, r, true) || recursion(s, l, r - 1, true)
        }
        l++
        r--
    }
    return true
}