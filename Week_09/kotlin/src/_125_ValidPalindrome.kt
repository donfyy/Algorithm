fun isPalindrome(s: String): Boolean {
    if (s.isEmpty()) return true
    var l = 0
    var r = s.length - 1
    while (l < r) {
        while (l < r && !Character.isLetterOrDigit(s[l])) l++
        while (l < r && !Character.isLetterOrDigit(s[r])) r--
        if (Character.toLowerCase(s[l]) == Character.toLowerCase(s[r])) {
            l++
            r--
        } else {
            return false
        }
    }
    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
}