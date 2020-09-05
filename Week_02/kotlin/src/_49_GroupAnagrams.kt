fun groupAnagrams(strs: Array<String>): List<List<String>> {
    fun key(s: String): String {
        val map = IntArray(26)
        s.forEach { map[it - 'a']++ }
        return map.contentToString()
    }

    val map = HashMap<String, MutableList<String>>()
    strs.forEach { map.computeIfAbsent(key(it)) { mutableListOf() } += it }
    return map.values.toList()
}

private fun key(it: String) = String(it.toCharArray().apply { sort() })

private fun key1(s: String): String {
    val map = IntArray(26)
    s.forEach { map[it - 'a']++ }
    return StringBuilder().apply {
        map.forEach { append(it).append(",") }
    }.toString()
}

fun main() {
    println(key1("bdddddddddd"))
    println(key1("bbbbbbbbbbc"))
}

