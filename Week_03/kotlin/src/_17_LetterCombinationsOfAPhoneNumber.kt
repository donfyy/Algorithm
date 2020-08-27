import java.util.*

fun letterCombinations(digits: String): List<String> {
    val map = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    val path = StringBuilder()
    val ret = mutableListOf<String>()
    val n = digits.length.takeIf { it > 0 } ?: return ret
    fun dfs(i: Int) {
        if (i == n) {
            ret += path.toString()
            return
        }

        for (c in map[digits[i] - '2']) {
            path.append(c)
            dfs(i + 1)
            path.deleteCharAt(path.lastIndex)
        }
    }
    dfs(0)
    return ret
}

class _17_BFS_ {
    fun letterCombinations(digits: String): List<String> {
        val n = digits.length.takeIf { it > 0 } ?: return emptyList()
        val map = arrayOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val queue = LinkedList<String>().apply { offer("") }
        while (queue.peek().length != n) {
            val e = queue.poll()
            for (c in map[digits[e.length] - '2']) {
                queue.offer(e + c)
            }
        }
        return queue
    }
}