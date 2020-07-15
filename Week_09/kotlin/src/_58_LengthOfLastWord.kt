fun lengthOfLastWord(s: String): Int {
    if (s.isEmpty()) return 0
    var end = s.length - 1
    while (end >= 0 && s[end] == ' ') end--
    if (end < 0) return 0
    var start = end
    while (start >= 0 && s[start] != ' ') start--
    return end - start
}

fun main() {
    println('A'.toInt())
    println('Z'.toInt())
    println('z'.toInt())
    println('a'.toInt())
    println('0'.toInt())
    println('9'.toInt())
    println('+'.toInt())
    println('-'.toInt())
    println(Integer.MAX_VALUE)
}