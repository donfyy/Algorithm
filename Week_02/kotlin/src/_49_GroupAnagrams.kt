class _49_GroupAnagrams_ {
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

    class Solution {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            fun key(s: String): String {
                val cnt = IntArray(26)
                s.forEach { cnt[it - 'a']++ }
                return cnt.contentToString()
            }
            val groups = HashMap<String, MutableList<String>>()
            strs.forEach { groups.computeIfAbsent(key(it)){ mutableListOf() }.add(it)}
            return groups.values.toList()
        }
    }
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